"use strict";
angular.module('relaxApp', ['ui.bootstrap', 'chieffancypants.loadingBar'])
    .controller('AuthController', function($scope, $rootScope, $http, AuthService, UserService) {
        var authService = new AuthService();
        var userService = new UserService();
        $scope.authService = authService;
        if (authService.isTokenExists()) {
            $rootScope.isAuth = true;
            userService.getUserInfo(authService.getLocalToken());
        } else {
            $rootScope.isAuth = false;
        }
})
    .factory('UserService', function($http, $rootScope) {
        var UserService = function () {
        };
        UserService.prototype.getUserInfo = function(token) {
            $http.get(CONF.apiUrl + 'user/info?token=' + token)
                .success(function(response) {
                    $rootScope.user = response.data;
                });
        };
        return UserService;
})
    .factory('AuthService', function($http, $rootScope, $modal, UserService) {
        var _STORAGE_TOKEN_NAME = 'token';
        var Auth = function() {};
        Auth.prototype.getLocalToken = function() {
            return localStorage[_STORAGE_TOKEN_NAME];
        };
        Auth.prototype.isTokenExists = function() {
            return !!this.getLocalToken();
        };
        Auth.prototype.requestNewToken = function(auth, callback, errorCallback) {
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
        Auth.prototype.logout = function() {
            if (this.isTokenExists()) {
                $http.delete(CONF.authUrl, {params: {token: this.getLocalToken()}})
                    .success(function() {
                        localStorage.removeItem(_STORAGE_TOKEN_NAME);
                        $rootScope.isAuth = false;
                    });
            }
        };
        Auth.prototype.openLoginWindow = function() {
            this.loginWindow = $modal.open({
                templateUrl: 'tmpl/auth.html',
                controller: 'LoginWindowController'
            });
        };
        Auth.prototype.closeLoginWindow = function() {
            this.loginWindow.close();
        };
        return Auth;
})
    .controller('LoginWindowController', function($scope, $modalInstance, AuthService) {
        $scope.authService = new AuthService();
        $scope.auth = {login: '', pass: ''};
        $scope.close = function () {
            $modalInstance.dismiss();
        };
        $scope.error = function(response) {
            $scope.errorMessage = response.status.message;
        };
    })
;

