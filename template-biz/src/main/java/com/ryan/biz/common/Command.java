package com.ryan.biz.common;

/**
 * Create by Ryan on 2023/3/23 22:37
 * Version 1.0
 * Description 指令
 */
public interface Command<Entity> {

    /**
     * 匹配条件则执行指令
     *
     * @param entity 业务参数
     * @return 是否执行
     */
    default boolean match(Entity entity) {
        return true;
    }

    /**
     * 执行命令之前的逻辑处理
     *
     * @param entity 业务参数
     */
    default void before(Entity entity) {
        // do something there
    }

    /**
     * 执行指令
     */
    void execute(Entity entity);

}
