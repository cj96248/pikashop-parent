package com.chao.service;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.pojo.TypeTemplateDo;

import java.util.List;

/**
 * 类型模板服务层接口
 *
 */
public interface TypeTemplateService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TypeTemplateDo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public CommonResult<TypeTemplateDo> findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加类型模板
	*/
	public void add(TypeTemplateDo typeTemplate);
	
	
	/**
	 * 修改类型模板
	 */
	public void update(TypeTemplateDo typeTemplate);
	

	/**
	 * 根据ID获取类型模板
	 * @param id
	 */
	public TypeTemplateDo findOne(Long id);
	
	
	/**
	 * 批量删除类型模板
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 */
	public CommonResult<TypeTemplateDo> findPage(TypeTemplateDo typeTemplate, int pageNum, int pageSize);

	/**
	 * 为下拉列表查找所有类型模板，[{id:xx,text:yy},{...}]
	 */
	List<SelectResult> findTypeSelections();
	

	
}
