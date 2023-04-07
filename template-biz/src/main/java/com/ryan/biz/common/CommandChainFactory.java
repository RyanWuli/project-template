package com.ryan.biz.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create by Ryan on 2023/4/5 19:24
 * Version 1.0
 * Description explain
 */
@Slf4j
public class CommandChainFactory implements InitializingBean, ApplicationContextAware {

    private ApplicationContext context;

    private Map<Name, List<CommandWrapper>> chainCache = Maps.newHashMap();

    public <T> CommandChain<T> buildChain(Name name) {
        // 每次新生成，不然会有并发问题
        return new DefaultCommandChain(chainCache.get(name));
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> map = context.getBeansWithAnnotation(TransCommand.class);
        if (map.size() == 0) {
            return;
        }

        List<CommandWrapper> list = Lists.newArrayList();
        List<CommandWrapper> allIn = Lists.newArrayList();

        map.forEach((key, value) -> {
            if (value instanceof Command) {
                // transCommand 不可能为空，因为 map 是通过 transCommand 的注解来获取的
                TransCommand transCommand = context.findAnnotationOnBean(key, TransCommand.class);
                for (TransCommand.Chain chain : transCommand.chains()) {
                    if (chain.name() == Name.ALL_IN) {
                        allIn.add(new CommandWrapper((Command) value, chain));
                        continue;
                    }
                    list.add(new CommandWrapper((Command) value, chain));
                }
            } else {
                log.warn("类{}注解[TransCommand]使用错误，请检查", value.getClass());
            }
        });

        // 组装所有的链
        if (list.size() > 0) {
            // 分组/排序
            list.stream().collect(Collectors.groupingBy(CommandWrapper::getName)).forEach((key, value) -> {
                allIn.forEach(cmd -> value.add(new CommandWrapper(cmd, key)));
                value.sort(Comparator.comparingInt(CommandWrapper::getOrder));
                chainCache.put(key, value);
            });
        }

        // 初始化结果检查
        for (Name name : Name.values()) {
            // ALL_IN 不是业务链不需要组装成一条链
            if (name == Name.ALL_IN) {
                continue;
            }

            if (chainCache.get(name) == null) {
                throw new Exception(String.format("流程（%s）错误，请检查"));
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
