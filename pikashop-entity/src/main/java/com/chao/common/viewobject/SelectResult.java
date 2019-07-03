package com.chao.common.viewobject;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SelectResult implements Serializable {
    private long id;

    private String text;
}
