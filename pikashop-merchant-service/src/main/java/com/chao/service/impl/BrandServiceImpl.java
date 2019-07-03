package com.chao.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.mapper.BrandDoMapper;
import com.chao.mybatis.pojo.BrandDo;
import com.chao.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    @Override
    public List<SelectResult> listSelectionBrand() {
        List<BrandDo> brands = brandDoMapper.listBrand();
//        if(!brands.isEmpty()){
//            return brands.stream().map(b -> new SelectResult(b.getId(),b.getName())).collect(Collectors.toList());
//        }
        return null;
    }

    @Override
    public CommonResult<List<BrandDo>> searchBrand(String keyword, int pageNum, int pageSize) {
        log.info("Search -> {}, from {} to {}"+ keyword, pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        Page<BrandDo> pages = (Page<BrandDo>) brandDoMapper.searchBrand(keyword);
        return CommonResult.build(pages.getTotal(), pages.getResult());
    }

    @Override
    public void insert(BrandDo brand) {
        brandDoMapper.insert(brand);
    }

    @Override
    public BrandDo selectById(long id) {
        log.info("Find by id ->" + id);
        return brandDoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(BrandDo brand) {
        brandDoMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteByIds(long[] ids) {
        log.info("Delete by id ->" + ids);
        brandDoMapper.deleteByIds(ids);
    }
}
