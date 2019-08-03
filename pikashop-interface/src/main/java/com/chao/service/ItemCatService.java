package com.chao.service;
import java.util.List;

import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.ItemCatDo;

/**
 * 商品项接口
 *
 */
public interface ItemCatService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<ItemCatDo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public CommonResult<ItemCatDo> findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(ItemCatDo itemCat);
	
	
	/**
	 * 修改
	 */
	public void update(ItemCatDo itemCat);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public ItemCatDo findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public CommonResult<ItemCatDo> findPage(ItemCatDo itemCat, int pageNum, int pageSize);

	List<ItemCatDo> findByParentId(Long parentId);
	
}
