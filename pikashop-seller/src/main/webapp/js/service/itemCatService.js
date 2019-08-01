app.service('itemCatService', function ($http) {
    this.findOne=function(id){
        return $http.get('../biz/itemCat/one?id='+id);
    }
    this.findChildren = function (parentId) {
        return $http.get('../biz/itemCat/findByParentId?parentId='+parentId);
    }
    this.findAll = function(){
        return $http.get('../biz/itemCat/categories');
    }
})