package cn.it.xiaodongbei.springframework.beans.factory.config;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  16:59
 * @Description: TODO
 * @Version: 1.0
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
