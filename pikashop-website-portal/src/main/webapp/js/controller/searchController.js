app.controller("searchController", function ($scope, searchService) {

    $scope.searchParam ={};
    $scope.searchItem = function () {
        searchService.searchItem($scope.searchParam).success(
            function (response) {
                $scope.resultItems = response.data;
            }
        )
    }
})