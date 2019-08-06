package com.chao.controller;

import java.util.List;

import com.chao.mybatis.website.pojo.ContentDo;
import com.chao.website.service.ContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;
	
	@RequestMapping("/findByCategoryId")
	public List<ContentDo> findByCategoryId(Long categoryId) {
		return contentService.findByCategoryId(categoryId);
	}
	
}
