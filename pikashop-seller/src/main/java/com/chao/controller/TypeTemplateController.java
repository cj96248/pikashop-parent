package com.chao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.pojo.TypeTemplateDo;
import com.chao.service.TypeTemplateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

	@Reference
	private TypeTemplateService typeTemplateService;

	
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

	@RequestMapping("/selections")
	public List<SelectResult> listBrands(){
		return typeTemplateService.findTypeSelections();
	}

	
}
