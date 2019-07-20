app.controller('sellerController', function ($scope, sellerService) {
    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        sellerService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        sellerService.findOne(id).success(
            function(response){
                $scope.seller= response;
            }
        );
    }
    $scope.updateStatus=function(id, status){
        sellerService.updateStatus(id, status).success(
            function (response) {
                if(response.status){
                    window.location.reload();
                }else {
                    alert(response.message);
                }
            }
        )
    }
})