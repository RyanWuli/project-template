package com.ryan.biz.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by Ryan on 2023/4/10 22:28
 * Version 1.0
 * Description 请求信息
 */
@Data
public class Request<Order extends OrderBase> implements Serializable {

    private static final long serialVersionUID = -8740765029705670990L;

    private OrderBase order;

    private String requestNo;
}
