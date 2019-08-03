package com.chao.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.mapper.TypeTemplateDoMapper;
import com.chao.mybatis.pojo.TypeTemplateDo;
import com.chao.mybatis.pojo.TypeTemplateDoExample;
import com.chao.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

	@Autowired
	private TypeTemplateDoMapper typeTemplateMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TypeTemplateDo> findAll() {
		return typeTemplateMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public CommonResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TypeTemplateDo> page=   (Page<TypeTemplateDo>) typeTemplateMapper.selectByExample(null);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TypeTemplateDo typeTemplate) {
		typeTemplateMapper.insert(typeTemplate);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TypeTemplateDo typeTemplate){
		typeTemplateMapper.updateByPrimaryKey(typeTemplate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TypeTemplateDo findOne(Long id){
		return typeTemplateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			typeTemplateMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public CommonResult findPage(TypeTemplateDo typeTemplate, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TypeTemplateDoExample example = new TypeTemplateDoExample();
		TypeTemplateDoExample.Criteria criteria = example.createCriteria();

		if(typeTemplate!=null){
			if(typeTemplate.getName()!=null && typeTemplate.getName().length()>0){
							criteria.andNameLike("%"+typeTemplate.getName()+"%");
			}if(typeTemplate.getSpecIds()!=null && typeTemplate.getSpecIds().length()>0){
				criteria.andSpecIdsLike("%"+typeTemplate.getSpecIds()+"%");
			}
			if(typeTemplate.getBrandIds()!=null && typeTemplate.getBrandIds().length()>0){
				criteria.andBrandIdsLike("%"+typeTemplate.getBrandIds()+"%");
			}
			if(typeTemplate.getCustomAttributeItems()!=null && typeTemplate.getCustomAttributeItems().length()>0){
				criteria.andCustomAttributeItemsLike("%"+typeTemplate.getCustomAttributeItems()+"%");
			}
		}
		
		Page<TypeTemplateDo> page= (Page<TypeTemplateDo>)typeTemplateMapper.selectByExample(example);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	@Override
	public List<SelectResult> findTypeSelections() {
		List<TypeTemplateDo> list = typeTemplateMapper.selectByExample(null);
		if(list != null){
			return list.stream().map(t -> new SelectResult(t.getId(), t.getName())).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}


}
