app.service('sellerService', function ($http) {
    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../manage/seller/list');
    }
    //查询实体
    this.findOne=function(id){
        return $http.get('../manage/seller/one?id='+id);
    }
    //修改
    this.updateStatus=function(id, status){
        return  $http.post('../manage/seller/updateStatus?sellerId='+id + '&status='+status );
    }

})