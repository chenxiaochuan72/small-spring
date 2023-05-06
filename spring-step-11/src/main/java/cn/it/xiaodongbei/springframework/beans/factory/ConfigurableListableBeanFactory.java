package cn.it.xiaodongbei.springframework.beans.factory;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanDefinition;
import cn.it.xiaodongbei.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  20:00
 * @Description: 提供分析和修改Bean以及预先实例化的操作接口
 * @Version: 1.0
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
