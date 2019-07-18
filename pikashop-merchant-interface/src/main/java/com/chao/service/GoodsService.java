package com.chao.service;

import com.chao.common.viewobject.CommonResult;
import com.chao.entity.viewobject.GoodsVO;
import com.chao.mybatis.pojo.GoodsDo;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<GoodsDo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public CommonResult<GoodsDo> findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(GoodsVO goods);
	
	
	/**
	 * 修改
	 */
	public void update(GoodsVO goods);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public GoodsDo findOne(Long id);

	public GoodsVO findOneDetail(Long id);
	
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
	public CommonResult<GoodsDo> findPage(GoodsDo goods, int pageNum, int pageSize);
	
}
