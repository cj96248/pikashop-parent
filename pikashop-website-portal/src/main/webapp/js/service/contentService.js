app.service('contentService',function ($http) {

    this.findByCategoryId=function(id){
        return $http.get('../portal/content/findByCategoryId?categoryId='+id);
    }
})