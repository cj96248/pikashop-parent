package com.chao.entity.viewobject;

import com.chao.mybatis.pojo.GoodsDescDo;
import com.chao.mybatis.pojo.GoodsDo;
import com.chao.mybatis.pojo.ItemDo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsVO implements Serializable {
    private GoodsDo goods;
    private GoodsDescDo goodsDesc;
    /**
     * 商品相关冗余数据
     */
    private GoodsRedundant goodsRedundant;

    private List<ItemDo> itemList;
}
