package com.chao.service;

import com.chao.common.viewobject.SelectAllResult;

import java.util.List;

/**
 * 商品相关服务
 */
public interface ProductService {

    /**
     * 选取商品的规格列表
     * @return [{"text":"网络制式","options":["移动3G","移动4G"]},{"text":"屏幕尺寸","options":["6寸","5寸"]}]
     */
    List<SelectAllResult> findGoodsSpecification(long id);
}
