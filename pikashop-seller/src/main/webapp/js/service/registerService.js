app.service('registerService',function ($http) {
    this.register=function(seller){
        return $http.post('../biz/seller/add',seller);
    }
})