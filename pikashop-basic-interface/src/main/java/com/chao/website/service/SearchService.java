package com.chao.website.service;

import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SearchParam;

/**
 * 搜索服务接口
 */
public interface SearchService {

    CommonResult searchItem(SearchParam param);

    CommonResult highlightWithFacetItem(SearchParam param) throws Exception;
}
