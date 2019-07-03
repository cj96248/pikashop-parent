package com.chao.service;


import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.pojo.BrandDo;

import java.util.List;

public interface BrandService {

    List<BrandDo> listBrand();

    CommonResult<List<BrandDo>> listBrandPage(int pageNum, int pageSize);

    List<SelectResult> listSelectionBrand();

    CommonResult<List<BrandDo>> searchBrand(String keyword, int pageNum, int pageSize);

    void insert(BrandDo brand);

    BrandDo selectById(long id);

    void updateById(BrandDo brand);

    void deleteByIds(long[] ids);

}
