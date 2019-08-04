package com.chao.website.service;

import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.website.pojo.ContentCategoryDo;

import java.util.List;

/**
 * 首页内容目录接口
 */
public interface ContentCategoryService {

	/**
	 * 返回全部首页内容目录
	 * @return
	 */
	public List<ContentCategoryDo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public CommonResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加首页内容目录
	*/
	public void add(ContentCategoryDo contentCategory);
	
	
	/**
	 * 修改首页内容目录
	 */
	public void update(ContentCategoryDo contentCategory);
	

	/**
	 * 根据ID获取首页内容目录
	 * @param id
	 */
	public ContentCategoryDo findOne(Long id);
	
	
	/**
	 * 批量删除首页内容目录
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 */
	public CommonResult findPage(ContentCategoryDo contentCategory, int pageNum, int pageSize);
	
}
