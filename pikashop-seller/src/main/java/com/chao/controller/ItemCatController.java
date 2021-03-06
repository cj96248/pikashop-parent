package com.chao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.ItemCatDo;
import com.chao.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

	@Reference
	private ItemCatService itemCatService;

	/**
	 * 获取实体
	 * @param id
	 */
	@RequestMapping("/one")
	public ItemCatDo findOne(Long id){
		return itemCatService.findOne(id);
	}


	/**
	 * 根据上级ID查询商品分类列表
	 */
	@RequestMapping("/findByParentId")
	public List<ItemCatDo> findByParentId(Long parentId){
		return itemCatService.findByParentId(parentId);
	}
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/categories")
	public List<String> findAll(){
		List<ItemCatDo> list = itemCatService.findAll();
		return list.
				stream()
				.sorted(Comparator.comparing(ItemCatDo::getId))
				.map(i -> i.getName()).collect(Collectors.toList());
	}
}
