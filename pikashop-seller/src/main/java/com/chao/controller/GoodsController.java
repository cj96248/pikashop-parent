package com.chao.controller;

import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.entity.viewobject.GoodsVO;
import com.chao.mybatis.pojo.GoodsDo;
import com.chao.service.GoodsService;
import com.chao.util.LoginUserUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<GoodsDo> findAll(){
		return goodsService.findAll();
	}
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/page")
	public CommonResult<GoodsDo> findPage(int page, int rows){
		return goodsService.findPage(page, rows);
	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public CommonResult update(@RequestBody GoodsVO goods){
		try {
			goodsService.update(goods);
			return CommonResult.build(CommonEnum.UPDATE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.UPDATE_SUCCESS);
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/one")
	public GoodsDo findOne(Long id){
		return goodsService.findOne(id);		
	}

	@RequestMapping("/detail")
	public GoodsVO findDetail(Long id){
	    return goodsService.findOneDetail(id);
    }

    @RequestMapping("/insert")
    public CommonResult insert(@RequestBody GoodsVO goods){
        try {
            goodsService.add(goods);
            return CommonResult.build(CommonEnum.SAVE_SUCCESS);
        } catch (Exception e) {
            return CommonResult.build(CommonEnum.SAVE_FAILED);
        }
    }

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CommonResult delete(Long [] ids){
		try {
			goodsService.delete(ids);
			return CommonResult.build(CommonEnum.DELETE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.DELETE_FAILED);
		}
	}
	
		/**
	 * 查询+分页
	 * @param goods
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public CommonResult<GoodsDo> search(@RequestBody GoodsDo goods, int page, int rows){
		goods.setSellerId(LoginUserUtil.getUserId());
		return goodsService.findPage(goods, page, rows);		
	}
	
}
