package com.chao.service;


import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.pojo.BrandDo;

import java.util.List;

public interface BrandService {

    List<BrandDo> listBrand();

    CommonResult<List<BrandDo>> listBrandPage(int pageNum, int pageSize);
}
