app.service('brandService',function ($http) {

    this.findBrandSelections=function(){
        return $http.get('../manage/brand/selections');
    }
})