app.service('brandService',function ($http) {

    this.findBrandSelections=function(){
        $http.get('../manage/brand/selections');
    }
})