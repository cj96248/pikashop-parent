package com.chao.service.impl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.entity.viewobject.Specification;
import com.chao.mybatis.mapper.SpecOptionDoMapper;
import com.chao.mybatis.mapper.SpecificationDoMapper;
import com.chao.mybatis.pojo.SpecOptionDo;
import com.chao.mybatis.pojo.SpecOptionDoExample;
import com.chao.mybatis.pojo.SpecificationDo;
import com.chao.mybatis.pojo.SpecificationDoExample;
import com.chao.service.SpecificationService;
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
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private SpecificationDoMapper specificationMapper;
	
	@Autowired
	private SpecOptionDoMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SpecificationDo> findAll() {
		return specificationMapper.selectByExample(null);
	}

	@Override
	public List<SelectResult> findSpecSelections() {
		List<SpecificationDo> specifications = specificationMapper.selectByExample(null);
//		if(!specifications.isEmpty()){
//			return specifications.stream().map(s -> new SelectResult(s.getId(), s.getSpecName())).collect(Collectors.toList());
//		}
		return null;
	}

	/**
	 * 按分页查询
	 */
	@Override
	public CommonResult<SpecificationDo> findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<SpecificationDo> page=   (Page<SpecificationDo>) specificationMapper.selectByExample(null);
		return CommonResult.build(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	@Transactional
	public void add(Specification specification) {
		//获取规格实体
		SpecificationDo specificationDo = specification.getSpecification();
		specificationMapper.insert(specificationDo);

		//获取规格选项集合
		List<SpecOptionDo> specOptions = specification.getSpecOptions();
		for( SpecOptionDo option: specOptions){
			option.setSpecId(specificationDo.getId());//设置规格ID，仅MySQL生效
			specificationOptionMapper.insert(option);//新增规格
		}

	}

	/**
	 * 修改
	 */
	@Override
	@Transactional
	public void update(Specification specification){

		//获取规格实体
		SpecificationDo specificationDo = specification.getSpecification();
		specificationMapper.updateByPrimaryKey(specificationDo);

		//删除原来规格对应的规格选项

		SpecOptionDoExample example=new SpecOptionDoExample();
		SpecOptionDoExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(specificationDo.getId());
		specificationOptionMapper.deleteByExample(example);

		//获取规格选项集合
		List<SpecOptionDo> specOptions = specification.getSpecOptions();
		for( SpecOptionDo option: specOptions){
			option.setSpecId(specificationDo.getId());//设置规格ID
			specificationOptionMapper.insert(option);//新增规格
		}
		
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		
		Specification specification=new Specification();
		//获取规格实体
		SpecificationDo specificationDo = specificationMapper.selectByPrimaryKey(id);
		specification.setSpecification(specificationDo);

		//获取规格选项列表

		SpecOptionDoExample example=new SpecOptionDoExample();
		SpecOptionDoExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<SpecOptionDo> specificationOptionList = specificationOptionMapper.selectByExample(example);

		specification.setSpecOptions(specificationOptionList);
		return specification;//组合实体类

	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		specificationMapper.deleteByIds(ids);
		specificationOptionMapper.deleteBySpecIds(ids);
	}

	@Override
	public CommonResult<SpecificationDo> findPage(SpecificationDo specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		SpecificationDoExample example=new SpecificationDoExample();
		SpecificationDoExample.Criteria criteria = example.createCriteria();

		if(specification!=null){
			if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
		}
		Page<SpecificationDo> page= (Page<SpecificationDo>)specificationMapper.selectByExample(example);
		return CommonResult.build(page.getTotal(), page.getResult());
	}
	
}
