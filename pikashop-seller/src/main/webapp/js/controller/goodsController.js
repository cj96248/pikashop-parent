app.controller('goodsController' ,function($scope,$controller,goodsService,uploadService,itemCatService, typeTemplateService, productService){
	
	$controller('baseController',{$scope:$scope});//继承
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
		$scope.item.goodsDesc.introduction=editor.html();
		goodsService.add( $scope.item).success(
				function(response){
					if(response.status){
						window.location.reload();
					}else{
						alert(response.message);
					}
				}
		);
	}

	$scope.item = {goods:{}, goodsDesc:{itemImages:[]}}
	$scope.updateImage = function () {
		uploadService.imageUpload().success(
			function (response) {
				$scope.imageItem.url = response.url;
				$scope.imageItem.thumbnail_url = response.thumbnail_url;
			}
		)
	}

	$scope.appendImage = function () {
		$scope.item.goodsDesc.itemImages.push($scope.imageItem);
	}

	$scope.cleanImage = function (index) {
		$scope.item.goodsDesc.itemImages.splice(index, 1);
	}

	$scope.initMethod = function(){
		$scope.loadCategory1();
	}

	$scope.loadCategory1 = function () {
		itemCatService.findChildren(0).success(
			function (response) {
				$scope.category1IdList = response;
			}
		)
	}
	$scope.$watch('item.goods.category1Id',function (newValue, oldValue) {
		if(newValue == undefined){
			// do nothing here
		}else{
			itemCatService.findChildren(newValue).success(
				function (response) {
					$scope.category2IdList = response;
					$scope.typeTemplateInfo ='';
				}
			)
		}
	})

	$scope.$watch('item.goods.category2Id',function (newValue, oldValue) {
		if(newValue == undefined){
			// do nothing here
		}else {
			itemCatService.findChildren(newValue).success(
				function (response) {
					$scope.category3IdList = response;
					$scope.typeTemplateInfo = '';
				}
			)
		}
	})
	
	$scope.$watch('item.goods.category3Id', function (newValue, oldValue) {
		if(newValue == undefined){
			// do nothing here
		}else {
			itemCatService.findOne(newValue).success(
				function (response) {
					$scope.item.goods.typeTemplateId = response.typeId;
					$scope.typeTemplateInfo = "模板编号为 " + response.typeId;
				}
			);
		}
	})
	$scope.$watch('item.goods.typeTemplateId', function (newValue, oldValue) {
		if(newValue == undefined){
			// do nothing here
		}else {
			typeTemplateService.findOne(newValue).success(
				function (response) {
					$scope.brandList = JSON.parse(response.brandIds);
					$scope.item.goodsDesc.customAttributeItems = JSON.parse(response.customAttributeItems);
				}
			);
			productService.findSpecs(newValue).success(
				function (response) {
					$scope.specList = response;
				}
			)
		}
	})
	
	$scope.selectSpecs = function (name, value) {
		
	}

    
});
