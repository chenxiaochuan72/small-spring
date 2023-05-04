package cn.it.xiaodongbei.springframework.beans.factory.config;

import cn.it.xiaodongbei.springframework.beans.BeansException;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  17:00
 * @Description: TODO
 * @Version: 1.0
 */
public interface BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
