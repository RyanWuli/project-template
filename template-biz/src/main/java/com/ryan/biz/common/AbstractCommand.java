package com.ryan.biz.common;

/**
 * Create by Ryan on 2023/4/5 18:46
 * Version 1.0
 * Description explain
 */
public class AbstractCommand<Entity extends AbstractTransEntity> implements Command<Entity> {

    @Override
    public void execute(Entity entity, CommandChain chain) {

    }
}
