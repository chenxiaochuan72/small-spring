package cn.it.xiaodongbei.springframework.factory.support;

import cn.it.xiaodongbei.springframework.BeansException;
import cn.it.xiaodongbei.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  13:12
 * @Description: 实例化策略接口
 * @Version: 1.0
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
