package com.chao.service.impl;
import java.util.List;

import com.chao.common.viewobject.CommonResult;
import com.chao.entity.viewobject.GoodsVO;
import com.chao.mybatis.mapper.GoodsDescDoMapper;
import com.chao.mybatis.mapper.GoodsDoMapper;
import com.chao.mybatis.pojo.GoodsDescDo;
import com.chao.mybatis.pojo.GoodsDo;
import com.chao.mybatis.pojo.GoodsDoExample;
import com.chao.service.GoodsService;
import com.chao.util.LoginUserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDoMapper goodsMapper;

	@Autowired
	private GoodsDescDoMapper goodsDescMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<GoodsDo> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public CommonResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<GoodsDo> page=   (Page<GoodsDo>) goodsMapper.selectByExample(null);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(GoodsVO goods) {
		String userId = LoginUserUtil.getUserId();
		goods.getGoods().setSellerId(userId);
		goods.getGoods().setAuditStatus("0");//状态：未审核
		goodsMapper.insert(goods.getGoods());//插入商品基本信息
		log.info("Insert goods id {}", goods.getGoods().getId());
		goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());//将商品基本表的ID给商品扩展表
		goodsDescMapper.insert(goods.getGoodsDesc());//插入商品扩展表数据

	}


	
	/**
	 * 修改
	 */
	@Override
	@Transactional
	public void update(GoodsVO goods){
		GoodsDo good = goods.getGoods();
		goodsMapper.updateByPrimaryKey(good);

		GoodsDescDo goodsDesc = goods.getGoodsDesc();
		goodsDescMapper.updateByPrimaryKey(goodsDesc);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public GoodsDo findOne(Long id){
		return goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public GoodsVO findOneDetail(Long id) {
		GoodsVO goods = new GoodsVO();
		GoodsDo goodsDo = goodsMapper.selectByPrimaryKey(id);
		if(goodsDo != null){
			GoodsDescDo goodsDescDo = goodsDescMapper.selectByPrimaryKey(id);
			goods.setGoods(goodsDo);
			goods.setGoodsDesc(goodsDescDo);
		}
		return goods;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			goodsMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public CommonResult findPage(GoodsDo goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		GoodsDoExample example=new GoodsDoExample();
			GoodsDoExample.Criteria criteria = example.createCriteria();

			if(goods!=null){
						if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
							criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
						}
						if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
							criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
						}
						if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
							criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
						}
						if(goods.getCaption()!=null && goods.getCaption().length()>0){
							criteria.andCaptionLike("%"+goods.getCaption()+"%");
						}
						if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
							criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
						}
						if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
							criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
						}
	
		}
		
		Page<GoodsDo> page= (Page<GoodsDo>)goodsMapper.selectByExample(example);
		return CommonResult.build(page.getTotal(), page.getResult());
	}
	
}
