package com.chao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.common.viewobject.SelectAllResult;
import com.chao.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Reference
    private ProductService productService;

    @RequestMapping("/findSpecs")
    public List<SelectAllResult> findSpecList(long typeId){
        return productService.findGoodsSpecification(typeId);
    }

}
