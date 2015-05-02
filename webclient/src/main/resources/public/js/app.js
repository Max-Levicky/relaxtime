function Event($scope, $http) {
    $http.get('http://localhost:8080/api/event').
        success(function(data) {
            $scope.event = data;
        });
}