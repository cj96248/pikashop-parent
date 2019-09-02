package com.chao.solr;

import com.alibaba.fastjson.JSON;
import com.chao.mybatis.mapper.ItemDoMapper;
import com.chao.mybatis.pojo.ItemDo;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;

import java.util.List;
import java.util.Map;

@CommonsLog
public class ItemInsertion {

    private static final String COLLECTION = "pikashop";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-*.xml");
        SolrTemplate solrTemplate = context.getBean("solrTemplate",SolrTemplate.class);

        ItemDoMapper itemDoMapper = context.getBean("itemDoMapper", ItemDoMapper.class);

        List<ItemDo> items = itemDoMapper.selectByExample(null);
        log.info("Retrieve item size " + items.size());

        for(ItemDo item: items) {
            Map specs = JSON.parseObject(item.getSpec(), Map.class);
            item.setSpecMap(specs);
        }
        UpdateResponse updateResponse = solrTemplate.saveBeans(items);
        if(updateResponse.getStatus() ==0){
            log.info("Saving to Solr...");
            solrTemplate.commit();
        }else {
            log.error("Failed feed!");
        }
    }

}
