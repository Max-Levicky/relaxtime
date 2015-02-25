function Event($scope, $http) {
    $http.get('http://localhost/api/event').
        success(function(data) {
            $scope.event = data;
        });
}