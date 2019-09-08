app.controller("searchController", function ($scope, searchService) {

    $scope.searchParam ={};
    $scope.searchItem = function () {
        searchService.searchItem($scope.searchParam).success(
            function (response) {
                $scope.resultItems = response.data;
            }
        )
    }

    $scope.searchItemFacet = function () {
        searchService.searchItemFacet($scope.searchParam).success(
            function (response) {
                $scope.resultItems = response.data;
            }
        )
    }
})