app.service('itemCatService', function ($http) {
    this.findChildren = function (parentId) {
        return $http.get('../manage/itemCat/findByParentId?parentId='+parentId);
    }
    this.findOne=function(id){
        return $http.get('../manage/itemCat/one?id='+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../manage/itemCat/add',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../manage/itemCat/update',entity );
    }
})