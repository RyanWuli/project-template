package com.ryan.biz.common;

/**
 * Create by Ryan on 2023/3/23 23:08
 * Version 1.0
 * Description explain
 */
public enum Name {

    TEMPLATE_BIZ("TEMPLATE_BIZ", "业务模板")
    ;

    private String code;
    private String msg;

    Name(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
