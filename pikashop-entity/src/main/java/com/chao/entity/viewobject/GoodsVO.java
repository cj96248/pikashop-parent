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

    private List<ItemDo> items;
}
