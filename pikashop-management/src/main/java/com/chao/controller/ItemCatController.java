package com.chao.controller;
import java.util.List;

import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.ItemCatDo;
import com.chao.service.ItemCatService;
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
@RequestMapping("/itemCat")
public class ItemCatController {

	@Reference
	private ItemCatService itemCatService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<ItemCatDo> findAll(){
		return itemCatService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/page")
	public CommonResult<ItemCatDo> findPage(int page, int rows){
		return itemCatService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/add")
	public CommonResult add(@RequestBody ItemCatDo itemCat){
		try {
			itemCatService.add(itemCat);
			return CommonResult.build(CommonEnum.SAVE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.SAVE_FAILED);
		}
	}
	
	/**
	 * 修改
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/update")
	public CommonResult update(@RequestBody ItemCatDo itemCat){
		try {
			itemCatService.update(itemCat);
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
	public ItemCatDo findOne(Long id){
		return itemCatService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CommonResult delete(Long [] ids){
		try {
			itemCatService.delete(ids);
			return CommonResult.build(CommonEnum.DELETE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.DELETE_FAILED);
		}
	}
	
		/**
	 * 查询+分页
	 * @param itemCat
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public CommonResult<ItemCatDo> search(@RequestBody ItemCatDo itemCat, int page, int rows  ){
		return itemCatService.findPage(itemCat, page, rows);		
	}
	
	/**
	 * 根据上级ID查询商品分类列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/findByParentId")
	public List<ItemCatDo> findByParentId(Long parentId){
		return itemCatService.findByParentId(parentId);
	}
	
}
