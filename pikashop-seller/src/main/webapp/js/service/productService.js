app.service('productService', function ($http) {
    this.findSpecs = function (id) {
        return $http.get('../biz/product/findSpecs?typeId='+id);
    }
})