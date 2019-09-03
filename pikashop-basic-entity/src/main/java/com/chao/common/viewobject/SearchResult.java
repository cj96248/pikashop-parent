package com.chao.common.viewobject;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchResult implements Serializable {

    private List content;
    private List brand;
    private List category;

}
