package com.ryan.biz.common;

import lombok.Data;

/**
 * Create by Ryan on 2023/4/5 17:06
 * Version 1.0
 * Description explain
 */
@Data
public class CommandWrapper<Entity> implements Command<Entity> {

    private Command<Entity> command;

    private Name name;

    private int order;

    public CommandWrapper(Command<Entity> command, TransCommand.Chain chain) {
        this.command = command;
        this.name = chain.name();
        this.order = chain.order();
    }

    public CommandWrapper(CommandWrapper<Entity> command, Name name) {
        this.command = command.command;
        this.name = name;
        this.order = command.order;
    }

    @Override
    public boolean match(Entity entity) {
        return false;
    }

    @Override
    public void before(Entity entity) {

    }

    @Override
    public void execute(Entity entity, CommandChain chain) {

    }
}
