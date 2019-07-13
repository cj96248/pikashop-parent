package com.chao.entity.viewobject;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class LoginUser implements Serializable {
    private String id;
    private String name;
    private String status;
    private String loginTime;
    private String icon;
}
