package com.chao.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.mapper.BrandDoMapper;
import com.chao.mybatis.pojo.BrandDo;
import com.chao.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDoMapper brandDoMapper;

    @Override
    public List<BrandDo> listBrand() {
        return brandDoMapper.listBrand();
    }

    @Override
    public CommonResult<List<BrandDo>> listBrandPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<BrandDo> pages = (Page<BrandDo>) brandDoMapper.listBrand();
        return CommonResult.build(pages.getTotal(), pages.getResult());
    }
}
