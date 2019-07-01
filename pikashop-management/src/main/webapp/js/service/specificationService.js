//服务层
app.service('specificationService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../manage/specification/list');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../manage/specification/pages?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../manage/specification/one?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../manage/specification/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../manage/specification/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../manage/specification/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../manage/specification/search?page='+page+"&rows="+rows, searchEntity);
	}    	
	//下拉列表
	this.selectOptionList=function(){
		return $http.get('../manage/specification/selections');
	}
	
});
