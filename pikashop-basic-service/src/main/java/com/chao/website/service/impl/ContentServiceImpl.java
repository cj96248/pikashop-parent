package com.chao.website.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.mapper.website.ContentDoMapper;
import com.chao.mybatis.website.pojo.ContentDo;
import com.chao.mybatis.website.pojo.ContentDoExample;
import com.chao.website.service.ContentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * 服务实现层
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDoMapper contentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ContentDo> findAll() {
		return contentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public CommonResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<ContentDo> page=   (Page<ContentDo>) contentMapper.selectByExample(null);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(ContentDo content) {
		contentMapper.insert(content);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(ContentDo content){
		//查询原来的分组ID
		Long categoryId = contentMapper.selectByPrimaryKey(content.getId()).getCategoryId();

		contentMapper.updateByPrimaryKey(content);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ContentDo findOne(Long id){
		return contentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			//清除缓存
			Long categoryId = contentMapper.selectByPrimaryKey(id).getCategoryId();			

			contentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public CommonResult findPage(ContentDo content, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		ContentDoExample example=new ContentDoExample();
			ContentDoExample.Criteria criteria = example.createCriteria();

			if(content!=null){
						if(content.getTitle()!=null && content.getTitle().length()>0){
				criteria.andTitleLike("%"+content.getTitle()+"%");
			}
			if(content.getUrl()!=null && content.getUrl().length()>0){
				criteria.andUrlLike("%"+content.getUrl()+"%");
			}
			if(content.getPic()!=null && content.getPic().length()>0){
				criteria.andPicLike("%"+content.getPic()+"%");
			}
			if(content.getStatus()!=null && content.getStatus().length()>0){
				criteria.andStatusLike("%"+content.getStatus()+"%");
			}
	
		}
		
		Page<ContentDo> page= (Page<ContentDo>)contentMapper.selectByExample(example);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	@Override
	public List<ContentDo> findByCategoryId(Long categoryId) {
		List<ContentDo> list =  new ArrayList<>();
			ContentDoExample example=new ContentDoExample();
			ContentDoExample.Criteria criteria = example.createCriteria();
			criteria.andCategoryIdEqualTo(categoryId);//指定条件:分类ID
			criteria.andStatusEqualTo("1");//指定条件：有效
			example.setOrderByClause("sort_order");//排序			
			list = contentMapper.selectByExample(example);
		return list;
	}
	
}
