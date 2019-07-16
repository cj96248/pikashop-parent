package com.chao.controller;
import java.util.List;

import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.SellerDo;
import com.chao.service.SellerService;
import com.chao.util.PasswordUtil;
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
@RequestMapping("/seller")
public class SellerController {

	@Reference
	private SellerService sellerService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<SellerDo> findAll(){
		return sellerService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public CommonResult<SellerDo> findPage(int page, int rows){
		return sellerService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param seller
	 * @return
	 */
	@RequestMapping("/add")
	public CommonResult add(@RequestBody SellerDo seller){
		try {
			seller.setPassword(PasswordUtil.encrypt(seller.getPassword()));
			sellerService.add(seller);
			return CommonResult.build(CommonEnum.SAVE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.SAVE_FAILED);
		}
	}
	
	/**
	 * 修改
	 * @param seller
	 * @return
	 */
	@RequestMapping("/update")
	public CommonResult update(@RequestBody SellerDo seller){
		try {
			sellerService.update(seller);
			return CommonResult.build(CommonEnum.UPDATE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.UPDATE_FAILED);
		}
	}

	/**
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("/changePassword")
	public CommonResult changePassword(String id, String oldPassword, String newPassword){
		try {
			CommonEnum commonEnum = sellerService.changePassword(id, oldPassword, newPassword);
			return CommonResult.build(commonEnum);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.UPDATE_FAILED);
		}
	}
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public SellerDo findOne(String id){
		return sellerService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CommonResult delete(String [] ids){
		try {
			sellerService.delete(ids);
			return CommonResult.build(CommonEnum.DELETE_SUCCESS);
		} catch (Exception e) {
			return CommonResult.build(CommonEnum.DELETE_FAILED);
		}
	}
	
		/**
	 * 查询+分页
	 * @param seller
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public CommonResult search(@RequestBody SellerDo seller, int page, int rows  ){
		return sellerService.findPage(seller, page, rows);		
	}
	
}
