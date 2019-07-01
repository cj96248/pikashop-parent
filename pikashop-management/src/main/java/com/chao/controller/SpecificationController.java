package com.chao.controller;
import java.util.List;
import java.util.Map;

import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.entity.viewobject.Specification;
import com.chao.mybatis.pojo.SpecificationDo;
import com.chao.service.SpecificationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<SpecificationDo> findAll(){
		return specificationService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/pages")
	public CommonResult<SpecificationDo> findPage(int page, int rows){
		return specificationService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param specification
	 * @return
	 */
	@RequestMapping("/add")
	public CommonResult add(@RequestBody Specification specification){
		try {
			specificationService.add(specification);
			return CommonResult.build(CommonEnum.SAVE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(CommonEnum.SAVE_FAILED);
		}
	}
	
	/**
	 * 修改
	 * @param specification
	 * @return
	 */
	@RequestMapping("/update")
	public CommonResult update(@RequestBody Specification specification){
		try {
			specificationService.update(specification);
			return CommonResult.build(CommonEnum.UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(CommonEnum.UPDATE_FAILED);
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/one")
	public Specification findOne(Long id){
		return specificationService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CommonResult delete(Long [] ids){
		try {
			specificationService.delete(ids);
			return CommonResult.build(CommonEnum.DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(CommonEnum.DELETE_FAILED);
		}
	}
	
		/**
	 * 查询+分页
	 * @param specification
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public CommonResult<SpecificationDo> search(@RequestBody SpecificationDo specification, int page, int rows  ){
		return specificationService.findPage(specification, page, rows);		
	}

	@RequestMapping("/selections")
	public List<SelectResult> listBrands(){
		return specificationService.findSpecSelections();
		}

}
