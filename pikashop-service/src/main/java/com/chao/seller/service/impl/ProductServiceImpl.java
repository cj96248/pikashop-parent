package com.chao.seller.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.chao.common.viewobject.SelectAllResult;
import com.chao.common.viewobject.SelectResult;
import com.chao.mybatis.mapper.SpecOptionDoMapper;
import com.chao.mybatis.mapper.TypeTemplateDoMapper;
import com.chao.mybatis.pojo.SpecOptionDo;
import com.chao.mybatis.pojo.TypeTemplateDo;
import com.chao.seller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private TypeTemplateDoMapper typeTemplateMapper;
    
    @Autowired
    private SpecOptionDoMapper specOptionDoMapper;

    @Override
    public List<SelectAllResult> findGoodsSpecification(long typeId) {
        List<SelectAllResult> list = new ArrayList<>();
        TypeTemplateDo typeTemplate = typeTemplateMapper.selectByPrimaryKey(typeId);
        String specs = typeTemplate.getSpecIds();
        List<SelectResult> specList = JSONArray.parseArray(specs, SelectResult.class);
        for(SelectResult result : specList){
            List<SpecOptionDo> specOptions = specOptionDoMapper.selectBySpecId(result.getId());
            list.add(new SelectAllResult(result.getText(), specOptions.stream().map(s -> s.getOptionName()).collect(Collectors.toList())));
        }
        return list;
    }
}
