app.service('goodsService',function($http){
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('/biz/goods/list');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('/biz/goods/page?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('/biz/goods/one?id='+id);
	}
	this.findDetail=function(id){
		return $http.get('/biz/goods/detail?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('/biz/goods/insert',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('/biz/goods/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('/biz/goods/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('/biz/goods/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
