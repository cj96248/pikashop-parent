package com.chao.entity.viewobject;

import java.io.Serializable;

public enum UserStatusEnum implements Serializable {
    PENDING("0","待审核"),
    AUDITED("1","已审核"),
    FAILING("2","未通过"),
    CLOSED("3","已关闭");

    private String message;
    private String code;
    UserStatusEnum(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public static  String valuesOf(String code){
        for(UserStatusEnum statusEnum :values()){
            if(statusEnum.getCode().equals(code)){
                return statusEnum.getMessage();
            }
        }
        return "未知";
    }
}
