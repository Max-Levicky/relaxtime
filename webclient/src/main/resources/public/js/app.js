"use strict";
angular.module('relaxApp', ['ui.bootstrap'])
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
        Auth.prototype.requestNewToken = function(auth, callback) {
            $http.get(CONF.authUrl + "?login=" + auth.login + "&pass=" + auth.pass)
                .success(function(response) {
                    localStorage[_STORAGE_TOKEN_NAME] = response.data;
                    console.log(response);
                    if (callback) {
                        callback(response.data);
                    }
                    $rootScope.isAuth = true;
                    new UserService().getUserInfo(response.data);
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
    })
;

