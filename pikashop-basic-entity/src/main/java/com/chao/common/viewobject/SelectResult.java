package com.chao.common.viewobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectResult implements Serializable {
    private long id;

    private String text;
}
