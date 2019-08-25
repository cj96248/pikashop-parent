app.service('searchService', function ($http) {

    this.searchItem = function (param) {
        return $http.post("../portal/search/simple", param);
    }
})