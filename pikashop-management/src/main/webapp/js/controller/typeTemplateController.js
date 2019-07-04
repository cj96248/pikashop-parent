app.controller('typeTemplateController',function ($scope,$controller,brandService,typeTemplateService, specificationService) {

    $controller('baseController',{$scope:$scope});

    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        typeTemplateService.findAll().success(
            function(response){
                $scope.list=response.data;
            }
        );
    }

    //分页
    $scope.findPage=function(page,rows){
        typeTemplateService.findPage(page,rows).success(
            function(response){
                $scope.list=response.data;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        typeTemplateService.findOne(id).success(
            function(response){
                $scope.typ = response;
                //转换字符串为json对象（集合）
                $scope.typ.brandIds=  JSON.parse( $scope.typ.brandIds);
                $scope.typ.specIds= JSON.parse($scope.typ.specIds);
                $scope.typ.customAttributeItems = JSON.parse($scope.typ.customAttributeItems);

            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.typ.id!=null){//如果有ID
            serviceObject=typeTemplateService.update( $scope.typ ); //修改
        }else{
            serviceObject=typeTemplateService.add( $scope.typ  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.status){
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    }


    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        typeTemplateService.dele( $scope.selectIds ).success(
            function(response){
                if(response.status){
                    $scope.reloadList();//刷新列表
                    $scope.selectIds=[];
                }
            }
        );
    }

    $scope.searchEntity={};//定义搜索对象

    //搜索
    $scope.search=function(page,rows){
        typeTemplateService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.data;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.brandList={data:[]};//品牌列表
    //读取品牌列表
    $scope.findBrandList=function(){
        brandService.findBrandSelections().success(
            function(response){
                $scope.brandList={data:response};
            }
        );
    }
    $scope.specList={data:[]};//规格列表
    //读取规格列表
    $scope.findSpecList=function(){
        specificationService.selectOptionList().success(
            function(response){
                $scope.specList={data:response};
            }
        );
    }

    $scope.initSelections=function(){
        $scope.findBrandList();
        $scope.findSpecList();

    }

    //增加扩展属性行
    $scope.addTableRow=function(){
        $scope.typ.customAttributeItems.push({});
    }
    //删除扩展属性行
    $scope.deleTableRow=function(index){
        $scope.typ.customAttributeItems.splice( index,1);
    }

})