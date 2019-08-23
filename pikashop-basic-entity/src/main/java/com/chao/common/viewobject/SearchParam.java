package com.chao.common.viewobject;

import lombok.Data;

@Data
public class SearchParam {
    private String keyword;
    private int start;
    private int count;

}
