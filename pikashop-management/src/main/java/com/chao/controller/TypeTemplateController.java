package com.chao.controller;
import java.util.List;

import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.pojo.TypeTemplateDo;
import com.chao.service.TypeTemplateService;
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
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

	@Reference
	private TypeTemplateService typeTemplateService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<TypeTemplateDo> findAll(){
		return typeTemplateService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/pages")
	public CommonResult<TypeTemplateDo> findPage(int page, int rows){
		return typeTemplateService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param typeTemplate
	 * @return
	 */
	@RequestMapping("/add")
	public CommonResult add(@RequestBody TypeTemplateDo typeTemplate){
		try {
			typeTemplateService.add(typeTemplate);
			return CommonResult.build(CommonEnum.SAVE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.SAVE_FAILED);
		}
	}
	
	/**
	 * 修改
	 * @param typeTemplate
	 * @return
	 */
	@RequestMapping("/update")
	public CommonResult update(@RequestBody TypeTemplateDo typeTemplate){
		try {
			typeTemplateService.update(typeTemplate);
			return CommonResult.build(CommonEnum.UPDATE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.UPDATE_FAILED);
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/one")
	public TypeTemplateDo findOne(Long id){
		return typeTemplateService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CommonResult delete(Long [] ids){
		try {
			typeTemplateService.delete(ids);
			return  CommonResult.build(CommonEnum.DELETE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.DELETE_FAILED);
		}
	}
	
		/**
	 * 查询+分页
	 * @param typeTemplate
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public CommonResult<TypeTemplateDo> search(@RequestBody TypeTemplateDo typeTemplate, int page, int rows){
		return typeTemplateService.findPage(typeTemplate, page, rows);
	}

	@RequestMapping("/selections")
	public List<SelectResult> listBrands(){
		return typeTemplateService.findTypeSelections();
	}

	
}
