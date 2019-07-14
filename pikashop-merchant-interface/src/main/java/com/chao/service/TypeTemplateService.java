package com.chao.service;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.pojo.TypeTemplateDo;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
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
	 * 增加
	*/
	public void add(TypeTemplateDo typeTemplate);
	
	
	/**
	 * 修改
	 */
	public void update(TypeTemplateDo typeTemplate);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TypeTemplateDo findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public CommonResult<TypeTemplateDo> findPage(TypeTemplateDo typeTemplate, int pageNum, int pageSize);

	List<SelectResult> findTypeSelections();
	

	
}
