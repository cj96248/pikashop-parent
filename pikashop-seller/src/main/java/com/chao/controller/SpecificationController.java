package com.chao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.entity.viewobject.Specification;
import com.chao.service.SpecificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;

	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/one")
	public Specification findOne(Long id){
		return specificationService.findOne(id);		
	}

}
