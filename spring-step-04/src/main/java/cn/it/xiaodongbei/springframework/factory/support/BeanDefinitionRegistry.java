package cn.it.xiaodongbei.springframework.factory.support;

import cn.it.xiaodongbei.springframework.factory.config.BeanDefinition;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: TODO
 * @Version: 1.0
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
