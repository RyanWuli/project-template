package com.ryan.biz.base.context;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ryan.biz.base.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;
import java.util.Map;

/**
 * Created by Ryan at 2023/4/16 14:38
 * Version 1.0
 * Description 服务上下文
 */
public final class ServiceContext<Order extends OrderBase, Result extends ResultBase> {

    /**
     * 请求参数
     */
    private Request<Order> request;

    /**
     * 应答
     */
    private Response<Result> response;

    /**
     * 实体
     */
    private AbstractEntity entity;

    /**
     * 实体列表
     */
    private List<AbstractEntity> entities;

    /**
     * 执行上下文，用于存放临时变量
     */
    private Map<String, Object> ctx = Maps.newHashMap();

    /**
     * savePoint
     */
    private Object savePoint;

    /**
     * 是否跳过通知节点
     */
    private boolean skipNotifyNode = false;

    public ServiceContext(Request<Order> request) {
        this.request = request;
        this.response = new Response<>();
    }

    /**
     * 这个设置 entities 的方法需要根据实际使用的业务需要来定
     *
     * @param entities 实体列表
     */
    public void setEntities(List<? extends AbstractEntity> entities) {
        if (this.entities == null) {
            this.entities = Lists.newArrayList();
            this.entities.addAll(entities);
            return;
        }
        this.entities.clear();
        this.entities.addAll(entities);
    }

    public boolean isSkipNotifyNode() {
        return this.skipNotifyNode;
    }

    public ServiceContext skipNotifyNode() {
        this.skipNotifyNode = true;
        return this;
    }

    public <T> T getProperty(String key) {
        return (T) this.ctx.get(key);
    }

    public void setProperty(String key, Object value) {
        this.ctx.put(key, value);
    }

    public Map<String, Object> getCtx() {
        return ctx;
    }

    public Request<Order> getRequest() {
        return request;
    }

    public Response<Result> getResponse() {
        return response;
    }

    public <T extends AbstractEntity> List<T> getEntities() {
        return (List<T>) this.entities;
    }

    public <T extends AbstractEntity> void addEntity(T entity) {
        if (this.entities == null) {
            this.entities = Lists.newArrayList();
        }
        this.entities.add(entity);
    }

    public Object getSavePoint() {
        return savePoint;
    }

    public void setSavePoint(Object savePoint) {
        this.savePoint = savePoint;
    }
}
