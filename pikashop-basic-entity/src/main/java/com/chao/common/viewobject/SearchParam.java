package com.chao.common.viewobject;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchParam implements Serializable {
    private String keyword;
    private int start;
    private int count;

}
