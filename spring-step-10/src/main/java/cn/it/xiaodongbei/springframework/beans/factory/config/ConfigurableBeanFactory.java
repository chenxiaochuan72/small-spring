package cn.it.xiaodongbei.springframework.beans.factory.config;

import cn.it.xiaodongbei.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  20:13
 * @Description: TODO
 * @Version: 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

}
