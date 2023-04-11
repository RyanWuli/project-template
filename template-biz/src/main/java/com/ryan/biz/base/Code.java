package com.ryan.biz.base;

/**
 * Create by Ryan on 2023/4/10 22:33
 * Version 1.0
 * Description 状态码
 */
public enum Code {
    SUCCESS("200", "成功"),
    FAILURE("500", "失败")
    ;

    private String code;
    private String msg;

    Code(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
