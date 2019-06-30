package com.chao.entity.viewobject;

import com.chao.mybatis.pojo.SpecOptionDo;
import com.chao.mybatis.pojo.SpecificationDo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Specification implements Serializable {
    private SpecificationDo specification;

    private List<SpecOptionDo> specOptions;
}