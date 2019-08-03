package com.chao.seller.service;
import java.util.List;

import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.SellerDo;
/**
 * 商家服务层接口
 *
 */
public interface SellerService {

	/**
	 * 返回全部商家
	 */
	public List<SellerDo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public CommonResult<SellerDo> findPage(int pageNum, int pageSize);

	/**
	 * 增加商家
	*/
	public void add(SellerDo seller);
	
	
	/**
	 * 修改基本信息
	 */
	public void update(SellerDo seller);

	/**
	 * 修改密码
	 */
	CommonEnum changePassword(String id, String oldPassword, String newPassword);

	/**
	 * 根据ID获取商家
	 * @param id
	 */
	public SellerDo findOne(String id);
	
	
	/**
	 * 批量删除商家
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 */
	public CommonResult<SellerDo> findPage(SellerDo seller, int pageNum, int pageSize);

	/**
	 * 修改商家状态
	 * @param sellerId
	 * @param status
	 */
	void updateStatus(String sellerId, String status);
	
}
