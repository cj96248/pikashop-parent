package com.chao.common.viewobject;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {
    /**
     * 返回结果条数
     */
    private long total;

    /**
     * 附带消息
     */
    private String message;

    /**
     * 返回状态码
     */
    private boolean status;

    /**
     * 返回结果集
     */
    private T data;

    public CommonResult(long total, String message, boolean status, T data) {
        this.total = total;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static <T> CommonResult build(long total, String message, boolean status, T data){
        return new CommonResult(total, message, status, data);
    }

    public static <T> CommonResult build(long total, T data){
        return new CommonResult(total, null, true, data);
    }

    public static CommonResult build(String message, boolean status){
        return new CommonResult(0, message, status, null);
    }
}
