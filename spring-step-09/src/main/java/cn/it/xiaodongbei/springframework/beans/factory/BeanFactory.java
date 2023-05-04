package cn.it.xiaodongbei.springframework.beans.factory;

import cn.it.xiaodongbei.springframework.beans.BeansException;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:56
 * @Description:  Bean 工厂接口用于获取 Bean 对象
 * @Version: 1.0
 */
public interface BeanFactory {
    /**
     * 获取Bean对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
