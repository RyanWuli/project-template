package com.ryan.biz.common;

/**
 * Create by Ryan on 2023/4/5 15:43
 * Version 1.0
 * Description 指令构成的链（责任链）
 */
public interface CommandChain<T> {

    /**
     * 执行下一个指令任务
     */
    void process(T target);

}
