package com.chao.solr;

import com.chao.mybatis.pojo.ItemDo;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;

import java.util.List;

public class ItemInsertion {

    private static final String COLLECTION = "pikashop";
    private static SolrTemplate solrTemplate;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:application-*.xml");
        solrTemplate = context.getBean("solrTemplate",SolrTemplate.class);

        ItemDo item = new ItemDo();
        item.setId(111L);
        item.setBrand("Lenove");
//        item.setTitle("聚美优品");
 //       item.setBrand("唯品会");
        solrTemplate.saveBean(item);
        solrTemplate.commit();
//        UpdateResponse updateResponse = solrTemplate.saveBean(COLLECTION, item);
//        int status = updateResponse.getStatus();
//        System.out.println(status);
//        solrTemplate.query(COLLECTION, , ItemDo.class);
    }

    public void feedItem2Solr(List<ItemDo> items){

    }

}
