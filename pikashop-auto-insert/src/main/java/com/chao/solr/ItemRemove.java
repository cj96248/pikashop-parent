package com.chao.solr;

import com.alibaba.fastjson.JSON;
import com.chao.mybatis.mapper.ItemDoMapper;
import com.chao.mybatis.pojo.ItemDo;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SolrDataQuery;

import java.util.List;
import java.util.Map;

@CommonsLog
public class ItemRemove {

    private static final String COLLECTION = "pikashop";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:application-*.xml");
        SolrTemplate solrTemplate = context.getBean("solrTemplate",SolrTemplate.class);

        SolrDataQuery query = new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
        log.info("Delete all item in Solr");
    }

}
