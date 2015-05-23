'use strict';
angular.module('relaxApp', ['ui.bootstrap', 'chieffancypants.loadingBar', 'ui.router'])
    .run(function($rootScope, UserService) {
        $rootScope.userService = new UserService();
        if ($rootScope.userService.isTokenExists()) {
            $rootScope.isAuth = true;
            $rootScope.userService.getUserInfo($rootScope.userService.getLocalToken());
        } else {
            $rootScope.isAuth = false;
        }
    })
    .controller('AuthController', function () {

    })
    .factory('UserService', function($http, $rootScope, $modal) {
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

