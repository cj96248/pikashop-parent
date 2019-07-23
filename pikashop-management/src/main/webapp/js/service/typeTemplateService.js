//服务层
app.service('typeTemplateService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../manage/typeTemplate/list');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../manage/typeTemplate/pages?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../manage/typeTemplate/one?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../manage/typeTemplate/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../manage/typeTemplate/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../manage/typeTemplate/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../manage/typeTemplate/search?page='+page+"&rows="+rows, searchEntity);
	}
	//搜索
	this.selectOptionList=function(){
		return $http.get('../manage/typeTemplate/selections');
	}
});
