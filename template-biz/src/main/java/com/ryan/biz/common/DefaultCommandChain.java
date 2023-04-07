package com.ryan.biz.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Create by Ryan on 2023/4/5 18:13
 * Version 1.0
 * Description explain
 */
@Slf4j
public class DefaultCommandChain<Entity> implements CommandChain<Entity> {

    private Iterator<CommandWrapper<Entity>> chain;


    public DefaultCommandChain(List<CommandWrapper<Entity>> commands) {
        // 这里可以排序，但是入参会排这里就不排序了
        // commands.sort(Comparator.comparing(CommandWrapper::getOrder));
        this.chain = commands.iterator();
    }

    @Override
    public void process(Entity entity) {
        if (chain.hasNext()) {
            Command<Entity> command = chain.next();
            log.info("执行节点[{}]", ((CommandWrapper) command).getCommand().getClass().getName());

            if (command.match(entity)) {
                // 前置处理
                command.before(entity);
                // 执行指令
                command.execute(entity, this);

            } else {
                log.info("跳过节点[{}]", ((CommandWrapper) command).getCommand().getClass().getName());
                // 递归调用下一个节点
                process(entity);
            }
        }
    }
}
