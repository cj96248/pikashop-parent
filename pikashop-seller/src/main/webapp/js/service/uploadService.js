app.service('uploadService', function($http){
    this.imageUpload= function(){
        var formData = new FormData();
        formData.append('file', file.files[0]);
        return $http({
            method:"POST",
            url:'https://imgurl.org/api/upload', //图床工具 https://imgurl.org/
            data: formData,
            headers: {'Content-Type':undefined},
            transformRequest:angular.identity
        });
    }
})