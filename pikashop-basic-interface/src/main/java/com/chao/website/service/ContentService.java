package com.chao.website.service;

import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.website.pojo.ContentDo;

import java.util.List;

/**
 * 内容服务层接口
 *
 */
public interface ContentService {

	/**
	 * 返回全部内容
	 * @return
	 */
	public List<ContentDo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public CommonResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加内容
	*/
	public void add(ContentDo content);
	
	
	/**
	 * 修改内容
	 */
	public void update(ContentDo content);
	

	/**
	 * 根据ID获取内容
	 * @param id
	 */
	public ContentDo findOne(Long id);
	
	
	/**
	 * 批量删除内容
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public CommonResult findPage(ContentDo content, int pageNum, int pageSize);
	
	/**
	 * 根据广告分类ID查询广告列表
	 * @param categoryId
	 * @return
	 */
	public List<ContentDo> findByCategoryId(Long categoryId);
	
}
