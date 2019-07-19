 //控制层 
app.controller('goodsController' ,function($scope,$controller,goodsService,uploadService){
	
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

    
});	
