package com.ryan.biz.base.context;

import com.ryan.biz.base.OrderBase;
import com.ryan.biz.base.ResultBase;

/**
 * Created by Ryan at 2023/4/16 15:28
 * Version 1.0
 * Description 本地线程变量持有 -  服务执行上下文
 */
public class ServiceContextHolder {
    
    private static  final ThreadLocal<ServiceContext<? extends OrderBase, ? extends ResultBase>> threadLocal = new ThreadLocal<>();

    public static <Order extends OrderBase, Result extends ResultBase> ServiceContext<Order, Result> get() {
        return (ServiceContext<Order, Result>) threadLocal.get();
    }

    public static void set(ServiceContext<? extends OrderBase, ? extends ResultBase> context) {
        threadLocal.set(context);
    }

    public void clear() {
        threadLocal.remove();
    }
}
