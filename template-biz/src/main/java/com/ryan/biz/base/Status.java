package com.ryan.biz.base;

/**
 * Create by Ryan on 2023/4/10 22:35
 * Version 1.0
 * Description 状态
 */
public enum Status {
    SUCCESS("SUCCESS", "成功"),
    FAILURE("FAILURE", "失败")
    ;

    private String code;
    private String msg;

    Status(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
