package com.ryan.biz.common;

/**
 * Create by Ryan on 2023/3/23 23:08
 * Version 1.0
 * Description explain
 */
public enum Name {

    // 通用的 command
    ALL_IN("ALL_IN", "该名称对应的 command 会加入所有的 chain"),

    SINGLE_TRANSFER("SINGLE_TRANSFER", "单笔转账"),

    BATCH_TRANSFER("BATCH_TRANSFER", "批量转账"),

    IMPOUND("IMPOUND", "强制扣划"),

    // 例子
    TEMPLATE_BIZ("TEMPLATE_BIZ", "业务模板")

    // ==
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
