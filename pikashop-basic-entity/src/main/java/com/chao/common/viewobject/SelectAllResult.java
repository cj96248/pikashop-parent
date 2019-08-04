package com.chao.common.viewobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectAllResult implements Serializable {

    private String text;

    private List<String> options;
}
