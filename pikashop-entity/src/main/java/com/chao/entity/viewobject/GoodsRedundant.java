package com.chao.entity.viewobject;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsRedundant implements Serializable {
    private String sellerId;
    private String sellerName;
    private String categoryName;
    private String brandName;
    private String imageUrl;
}
