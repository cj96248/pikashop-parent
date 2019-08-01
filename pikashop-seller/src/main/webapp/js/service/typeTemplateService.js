app.service('typeTemplateService',function($http){
	//查询实体
	this.findOne=function(id){
		return $http.get('../biz/typeTemplate/one?id='+id);
	}
	//搜索
	this.selectOptionList=function(){
		return $http.get('../biz/typeTemplate/selections');
	}
});
