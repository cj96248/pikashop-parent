package com.chao.website.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SearchParam;
import com.chao.mybatis.pojo.ItemDo;
import com.chao.website.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SolrTemplate solrTemplate;

    @Override
    public CommonResult searchItem(SearchParam param) {
        Query query = new SimpleQuery(param.getKeyword());
        ScoredPage<ItemDo> itemDos = solrTemplate.queryForPage(query, ItemDo.class);
        List<ItemDo> content = itemDos.getContent();
        return CommonResult.build(content.size(), content);
    }

    @Override
    public CommonResult highlightItem(SearchParam param) {
        List<ItemDo> content = new ArrayList<>();

        HighlightQuery query = new SimpleHighlightQuery();
        HighlightOptions options = new HighlightOptions();
        options.addField("title");
        query.setHighlightOptions(options);
        HighlightPage<ItemDo> itemDos = solrTemplate.queryForHighlightPage(query, ItemDo.class);
        List<HighlightEntry.Highlight> highlights = itemDos.getHighlighted().get(0).getHighlights();
        for (HighlightEntry.Highlight highlight : highlights) {
            List<String> snipplets = highlight.getSnipplets();
        }
        return CommonResult.build(content.size(), content);
    }

}
