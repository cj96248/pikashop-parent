package com.chao.website.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chao.common.viewobject.CommonResult;
import com.chao.common.viewobject.SearchParam;
import com.chao.common.viewobject.SearchResult;
import com.chao.mybatis.pojo.ItemDo;
import com.chao.website.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
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
    public CommonResult highlightWithFacetItem(SearchParam param) throws Exception {
        SearchResult result = new SearchResult();
        List<ItemDo> content = new ArrayList<>();

        SolrServer solrServer = solrTemplate.getSolrServer();
        SolrQuery params = new SolrQuery();
        params.setFacet(true);
        params.setFacetPrefix("brand", "brand");
        params.setFacetLimit(1);
        params.setHighlight(true);
        params.setHighlightSimplePre("<em style='color:red'>");
        params.setHighlightSimplePost("</em>");
        QueryResponse response = solrServer.query(params);

        FacetField brand = response.getFacetField("brand");

        result.setContent(content);
        result.setBrand(brand.getValues());

        return CommonResult.build(content.size(), result);
    }

}
