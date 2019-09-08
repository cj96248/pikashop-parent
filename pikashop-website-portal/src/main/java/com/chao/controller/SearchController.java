package com.chao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SearchParam;
import com.chao.website.service.SearchService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Reference
    private SearchService searchService;

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public CommonResult search(@RequestBody SearchParam param){
        return searchService.searchItem(param);
    }

    @RequestMapping(value = "/facet", method = RequestMethod.POST)
    public CommonResult search4Highlight(@RequestBody SearchParam param) throws Exception {
        return searchService.highlightWithFacetItem(param);
    }
}
