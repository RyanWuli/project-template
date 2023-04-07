package com.ryan.biz.common;

import java.lang.annotation.*;

/**
 * Create by Ryan on 2023/4/5 16:19
 * Version 1.0
 * Description 模板指令（比如交易 transCommand，区分不同的交易名称），commond 上使用（所以叫 xxxCommand）
 */
public @interface TransCommand {

    Chain[] chains();

    /**
     * 链
     *
     * 注解的元注解学习：https://blog.csdn.net/xsp_happyboy/article/details/80987484
     * @Documented 注解，是被用来指定自定义注解是否能随着被定义的java文件生成到JavaDoc文档当中。
     * @Target 注解，是专门用来限定某个自定义注解能够被应用在哪些Java元素上面的。
     * @Retention 注解，翻译为持久力、保持力。即用来修饰自定义注解的生命力。
     * @Inherited 注解，是指定某个自定义注解如果写在了父类的声明部分，那么子类的声明部分也能自动拥有该注解。@Inherited注解只对那些@Target被定义为ElementType.TYPE的自定义注解起作用。
     */
    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface Chain {
        /**
         * 模板指令的名称
         */
        Name name();

        /**
         * 在 chain 中的顺序
         */
        int order();
    }
}
