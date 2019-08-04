package com.chao.common.viewobject;

public enum CommonEnum {
    UNKNOWN_ERROR(10001, "未知错误"),
    SAVE_SUCCESS(20000, "保存成功"),
    SAVE_FAILED(20001, "保存失败"),
    DELETE_SUCCESS(20010, "删除成功"),
    DELETE_FAILED(20011, "删除失败"),
    UPDATE_SUCCESS(20020, "更新成功"),
    UPDATE_FAILED(20021, "更新失败"),
    UPDATE_PASSWORD_FAILED(20023, "密码不匹配"),
    NOT_FOUND(30011, "未找到结果")
    ;
    private int code;

    private String message;

    CommonEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int code(){
        return code;
    }

    public String message(){
        return message;
    }

}
