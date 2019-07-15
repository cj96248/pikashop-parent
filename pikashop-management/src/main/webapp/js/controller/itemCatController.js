app.controller('itemCatController', function ($scope, itemCatService, typeTemplateService) {
    //查询实体
    $scope.findOne=function(id){
        itemCatService.findOne(id).success(
            function(response){
                $scope.item= response;
            }
        );
    }
    $scope.findChildren = function (parentId) {
        itemCatService.findChildren(parentId).success(
            function (response) {
                $scope.items = response;
            }
        )
    }
    //面包屑级别
    $scope.gradeId = 1;
    $scope.setGradeId = function (id) {
        $scope.gradeId = id;
    }
    $scope.currentGradeList = function (itemCat) {
        if($scope.gradeId === 1){
            $scope.secondItem = null;
            $scope.thirdItem = null;
        }
        if($scope.gradeId === 2){
            $scope.secondItem = itemCat;
            $scope.thirdItem = null;
        }
        if($scope.gradeId === 3){
            $scope.thirdItem = itemCat;
        }
        $scope.findChildren(itemCat.id);
    }
    $scope.specList={data:[]};//规格列表
    //读取规格列表
    $scope.findSpecList=function(){
        typeTemplateService.selectOptionList().success(
            function(response){
                $scope.specList={data:response};
            }
        );
    }
    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        $scope.item.typeId = $scope.item.typeTemp['id'];
        if($scope.item.id!=null){//如果有ID
            serviceObject=itemCatService.update( $scope.item ); //修改
        }else{
            serviceObject=itemCatService.add( $scope.item  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.status){
                    //重新查询
                    window.location.reload();
                }else{
                    alert(response.message);
                }
            }
        );
    }
})