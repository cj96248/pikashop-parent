package com.chao.service.impl;
import java.util.List;

import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.mapper.ItemCatDoMapper;
import com.chao.mybatis.pojo.ItemCatDo;
import com.chao.mybatis.pojo.ItemCatDoExample;
import com.chao.service.ItemCatService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatDoMapper itemCatMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ItemCatDo> findAll() {
		return itemCatMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public CommonResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<ItemCatDo> page=   (Page<ItemCatDo>) itemCatMapper.selectByExample(null);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(ItemCatDo itemCat) {
		itemCatMapper.insert(itemCat);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(ItemCatDo itemCat){
		itemCatMapper.updateByPrimaryKey(itemCat);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ItemCatDo findOne(Long id){
		return itemCatMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			itemCatMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public CommonResult findPage(ItemCatDo itemCat, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ItemCatDoExample example=new ItemCatDoExample();
			ItemCatDoExample.Criteria criteria = example.createCriteria();

			if(itemCat!=null){
						if(itemCat.getName()!=null && itemCat.getName().length()>0){
							criteria.andNameLike("%"+itemCat.getName()+"%");
			}
	
		}
		
		Page<ItemCatDo> page= (Page<ItemCatDo>)itemCatMapper.selectByExample(example);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	@Override
	public List<ItemCatDo> findByParentId(Long parentId) {
		ItemCatDoExample example=new ItemCatDoExample();
		ItemCatDoExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		return itemCatMapper.selectByExample(example);
	}
	
}
