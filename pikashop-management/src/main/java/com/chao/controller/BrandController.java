package com.chao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.mybatis.pojo.BrandDo;
import com.chao.service.BrandService;
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
}
