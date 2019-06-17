package com.chao.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chao.mybatis.mapper.BrandDoMapper;
import com.chao.mybatis.pojo.BrandDo;
import com.chao.service.BrandService;
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
}
