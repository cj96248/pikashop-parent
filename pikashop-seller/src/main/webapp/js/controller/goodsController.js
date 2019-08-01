app.controller('goodsController' ,function($scope,$controller,$location,goodsService,uploadService,itemCatService, typeTemplateService, productService, loginService){

	$controller('baseController',{$scope:$scope});//继承

	//分页
	$scope.search=function(page,rows){
		goodsService.search(page,rows,$scope.item.goods).success(
			function(response){
				$scope.goodslist=response.data;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}
		);
	};

	checkId = function(){
		return $location.search()['id'];
	};

	//查询实体 
	$scope.findDetail=function(id){
		goodsService.findDetail(id).success(
			function(response){
				$scope.item= response;
				$scope.item.goods = response.goods;
			}
		);
	};
	//保存 
	$scope.save=function(){
		$scope.item.goodsDesc.introduction=editor.html();
		$scope.item.goodsRedundant.categoryName = $("#category3").find('option:selected').text();
		$scope.item.goodsRedundant.brandName = $("#brand").find('option:selected').text();
		$scope.item.goodsRedundant.imageUrl = $("#imageUrl").text();
		$scope.item.goods.sellerId = $scope.item.goodsRedundant.sellerId;
		goodsService.add( $scope.item).success(
				function(response){
					if(response.status){
						window.location.reload();
					}else{
						alert(response.message);
					}
				}
		);
	};

	$scope.item = {goods:{}, goodsDesc:{itemImages:[],specificationItems:[]},goodsRedundant:{}, itemList:[]};

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
		checkSeller();
		var id = checkId();
		if(id){
			$scope.findDetail(id);
		}
	};
	checkSeller = function(){
		loginService.loginSeller().success(
			function (response) {
				$scope.item.goodsRedundant.sellerId = response.data.id;
				$scope.item.goodsRedundant.sellerName = response.data.name;
			}
		);
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

	$scope.selectedSpecs = function ($event, name, value) {
		var spec = $scope.searchObjectByKey($scope.item.goodsDesc.specificationItems, 'name', name);
		if(spec != null){
			if($event.target.checked){
				spec.value.push(value);
			}else {
				spec.value.splice(spec.value.indexOf(value),1);
				if(spec.value.length == 0){
					$scope.item.goodsDesc.specificationItems.splice($scope.item.goodsDesc.specificationItems.indexOf(spec),1);
				}
			}
		}else{
			$scope.item.goodsDesc.specificationItems.push({'name':name,'value':[value]});
		}
	}

	$scope.createItems = function(){
		$scope.item.itemList = [{spec:{}, price:0, num:0, status:'0',isDefault:'0'}];
		var items = $scope.item.goodsDesc.specificationItems;
		for(var i =0; i< items.length;i++){
			$scope.item.itemList = addColumn($scope.item.itemList, items[i].name, items[i].value);
		}
		console.log($scope.item.itemList);
	}

	addColumn = function(list, columnName, columnValues){
		var newList = [];
		for(var i = 0; i< list.length; i++){
			var oldRow = list[i];
			for(var j=0; j<columnValues.length;j++){
				var newRow = JSON.parse(JSON.stringify(oldRow));
				newRow.spec[columnName.trim()] = columnValues[j];
				console.log(newRow);
				newList.push(newRow);
			}
		}
		return newList;
	}

	$scope.statusInfoList = ["未审核","审核通过","已驳回","已关闭"];

	$scope.cacheCategory = function(){
		itemCatService.findAll().success(
			function (response) {
				$scope.categoryList =response;

			}
		)
	}


});