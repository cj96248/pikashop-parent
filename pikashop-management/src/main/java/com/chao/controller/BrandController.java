package com.chao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.common.viewobject.CommonEnum;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.pojo.BrandDo;
import com.chao.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/list")
    public List<BrandDo> findAll(){
        return brandService.listBrand();
    }

    @RequestMapping("/pages")
    public CommonResult<List<BrandDo>> findPage(int pageNum, int pageSize){
        return brandService.listBrandPage(pageNum, pageSize);
    }
    @RequestMapping("/search")
    public CommonResult<List<BrandDo>> search(String keyword, int pageNum, int pageSize){
        return brandService.searchBrand(keyword, pageNum, pageSize);
    }
    @RequestMapping("/add")
    public CommonResult insert(@RequestBody BrandDo brand){
        try {
            brandService.insert(brand);
            return CommonResult.build(CommonEnum.SAVE_SUCCESS);
        }catch (Exception e){
            return CommonResult.build(CommonEnum.SAVE_FAILED);
        }
    }

    @RequestMapping("/one")
    public CommonResult<BrandDo> findById(long id){
        try {
            BrandDo brand = brandService.selectById(id);
            return CommonResult.build(1, brand);
        }catch (Exception e){
            return  CommonResult.build(CommonEnum.NOT_FOUND);
        }
    }

    @RequestMapping("/update")
    public CommonResult update(@RequestBody BrandDo brand){
        try {
            brandService.updateById(brand);
            return CommonResult.build(CommonEnum.UPDATE_SUCCESS);
        }catch (Exception e){
            return CommonResult.build(CommonEnum.UPDATE_FAILED);
        }
    }

    @RequestMapping("/delete")
    public CommonResult delete(long[] ids){
        try {
            brandService.deleteByIds(ids);
            return CommonResult.build(CommonEnum.DELETE_SUCCESS);
        }catch (Exception e){
            return CommonResult.build(CommonEnum.DELETE_FAILED);
        }
    }

    @RequestMapping("/selections")
    public List<SelectResult> listBrands(){
        return brandService.listSelectionBrand();
    }
}
