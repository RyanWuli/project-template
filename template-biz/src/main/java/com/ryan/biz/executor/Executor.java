package com.ryan.biz.executor;

import com.ryan.biz.base.OrderBase;
import com.ryan.biz.base.Request;
import com.ryan.biz.base.Response;
import com.ryan.biz.base.ResultBase;

/**
 * Create by Ryan on 2023/4/10 22:22
 * Version 1.0
 * Description 业务执行器
 */
public interface Executor<Order extends OrderBase, Result extends ResultBase> {

    /**
     * 执行业务
     *
     * @param request 请求信息
     * @return response 应答信息
     */
    Response<Result> execute(Request<Order> request);

}
