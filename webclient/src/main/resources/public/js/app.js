'use strict';
angular.module('relaxApp', ['ui.bootstrap', 'chieffancypants.loadingBar', 'ui.router'])
    .run(function($rootScope, UserService, WsService) {
        $rootScope.conf = CONF;
        $rootScope.userService = new UserService();
        if ($rootScope.userService.isTokenExists()) {
            $rootScope.isAuth = true;
            $rootScope.userService.getUserInfo(function (user) {
                $rootScope.ws = new WsService();
                $rootScope.ws.subscribeOnUserChannel(user);
            });
        } else {
            $rootScope.isAuth = false;
        }
    })
    .config(function($locationProvider) {
        $locationProvider.html5Mode(true);
    })
    .controller('AuthController', function () {

    })
    .factory('WsService', function ($q, $rootScope) {
        // Keep all pending requests here until they get responses
        var callbacks = {};
        // Create a unique callback ID to map requests to responses
        var currentCallbackId = 0;
        // Create our websocket object with the address to the websocket
        var ws = new SockJS(CONF.wsUrl);
        var subscribers = {};

        var WsService = function() {
            var inst = this;
            ws.onopen = function() {
                console.log("Socket has been opened!");
            };
            ws.onmessage = function(message) {
                inst.listener(JSON.parse(message.data));
            };
        };
        WsService.prototype.sendRequest = function(request) {
            var defer = $q.defer();
            var callbackId = this.getCallbackId();
            callbacks[callbackId] = {
                time: new Date(),
                cb:defer
            };
            request.callback_id = callbackId;
            console.log('Sending request', request);
            ws.send(JSON.stringify(request));
            return defer.promise;
        };
        WsService.prototype.subscribeOnUserChannel = function(user) {
            ws.subscribe('/events/' + user.id, function(event) {
                var handler = subscribers[event.type];
                handler(event);
            });
        };
        WsService.prototype.listener = function(data) {
            var messageObj = data;
            console.log("Received data from websocket: ", messageObj);
            // If an object exists with callback_id in our callbacks object, resolve it
            if(callbacks.hasOwnProperty(messageObj.callback_id)) {
                console.log(callbacks[messageObj.callback_id]);
                $rootScope.$apply(callbacks[messageObj.callback_id].cb.resolve(messageObj.data));
                delete callbacks[messageObj.callbackID];
            }
        };
        // This creates a new callback ID for a request
        WsService.prototype.getCallbackId = function() {
            currentCallbackId += 1;
            if(currentCallbackId > 10000) {
                currentCallbackId = 0;
            }
            return currentCallbackId;
        };
        return WsService;
    })
    .factory('EventService', function($rootScope) {
        var eventTypes = [];
        var EventService = function() {};
        EventService.prototype.listenEvents = function(user) {

        };

    })
    .factory('UserService', function($http, $rootScope, $modal, $state) {
        var _STORAGE_TOKEN_NAME = 'token';

        var UserService = function () {
        };
        UserService.prototype.getUserInfo = function(callback) {
            if (!$rootScope.user) {
                this.getUserInfoFromServer(this.getLocalToken(), callback);
            } else if (callback) {
                callback($rootScope.user);
            }
        };
        UserService.prototype.getUserInfoFromServer = function(token, callback) {
            $http.get(CONF.apiUrl + 'user/info?token=' + token)
                .success(function(response) {
                    $rootScope.user = response.data;
                    if (callback) {
                        callback(response.data);
                    }
                });
        };
        UserService.prototype.getLocalToken = function() {
            return localStorage[_STORAGE_TOKEN_NAME];
        };
        UserService.prototype.isTokenExists = function() {
            return !!this.getLocalToken();
        };
        UserService.prototype.requestNewToken = function(auth, callback, errorCallback) {
            $http.get(CONF.authUrl + "?login=" + auth.login + "&pass=" + auth.pass)
                .success(function(response) {
                    console.info(response);
                    localStorage[_STORAGE_TOKEN_NAME] = response.data;
                    if (callback) {
                        callback(response.data);
                    }
                    $rootScope.isAuth = true;
                    new UserService().getUserInfo(response.data);
                })
                .error(function(response) {
                    if (errorCallback) {
                        errorCallback(response);
                    }
                });
        };
        UserService.prototype.logout = function() {
            if (this.isTokenExists()) {
                $http.delete(CONF.authUrl, {params: {token: this.getLocalToken()}})
                    .success(function() {
                        localStorage.removeItem(_STORAGE_TOKEN_NAME);
                        $rootScope.isAuth = false;
                        $rootScope.user = null;
                        $state.go('start');
                    });
            }
        };
        UserService.prototype.startWork = function() {
            if (this.isTokenExists()) {
                $http.post(CONF.apiUrl + "user/startWork?token=" + this.getLocalToken())
                    .success(function(response) {
                        $rootScope.user = response.data;
                    });
            }
        };
        UserService.prototype.stopWork = function() {
            if (this.isTokenExists()) {
                $http.post(CONF.apiUrl + "user/stopWork?token=" + this.getLocalToken())
                    .success(function(response) {
                        $rootScope.user = response.data;
                    });
            }
        };
        UserService.prototype.openLoginWindow = function() {
            this.loginWindow = $modal.open({
                templateUrl: 'tmpl/auth.html',
                controller: 'LoginWindowController'
            });
        };
        UserService.prototype.closeLoginWindow = function() {
            this.loginWindow.close();
        };
        return UserService;
    })
    .controller('LoginWindowController', function($scope, $modalInstance, UserService) {
        $scope.userService = new UserService();
        $scope.auth = {login: '', pass: ''};
        $scope.close = function () {
            $modalInstance.dismiss();
        };
        $scope.error = function(response) {
            $scope.errorMessage = response.status.message;
        };
    })
    .config(function($stateProvider, $urlRouterProvider) {
        var tmplPath = '/tmpl/';
        //$routeProvider.when(ROUTES.USERINFO, {templateUrl: tmplPath + 'userInfo.html', controller: ''});
        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state('start', {
                url: '/',
                templateUrl: tmplPath + 'start.html'
            })
            .state('userinfo', {
                url: '/user/:username',
                templateUrl: tmplPath + 'user/info.html',
                controller: function($scope, $stateParams, UserService) {
                    new UserService().getUserInfo(function (user) {
                        console.log(user);
                        $scope.userInfo = user;
                    });
                }
            })
    })
;

