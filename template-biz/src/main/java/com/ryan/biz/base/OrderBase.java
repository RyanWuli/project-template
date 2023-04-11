package com.ryan.biz.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by Ryan on 2023/4/10 22:24
 * Version 1.0
 * Description order 基类
 */
@Data
public class OrderBase implements Serializable {

    private static final long serialVersionUID = -12476916740245467L;

    private String orderId;
}
