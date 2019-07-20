package com.chao.controller;
import java.util.List;

import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.SellerDo;
import com.chao.service.SellerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Reference
	private SellerService sellerService;
	/**
	 * 获取商家
	 * @param id
	 * @return
	 */
	@RequestMapping("/one")
	public SellerDo findOne(String id){
		return sellerService.findOne(id);
	}
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<SellerDo> findAll(){
		return sellerService.findAll();
	}

	@RequestMapping("/updateStatus")
	public CommonResult updateStatus(String sellerId,String status){
		try {
			sellerService.updateStatus(sellerId, status);
			return CommonResult.build(CommonEnum.UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(CommonEnum.UPDATE_FAILED);
		}
	}
	
}
