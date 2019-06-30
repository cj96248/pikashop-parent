package com.chao.service;
import java.util.List;

import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.SellerDo;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SellerService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<SellerDo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public CommonResult<SellerDo> findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(SellerDo seller);
	
	
	/**
	 * 修改
	 */
	public void update(SellerDo seller);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public SellerDo findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public CommonResult<SellerDo> findPage(SellerDo seller, int pageNum, int pageSize);
	
}
