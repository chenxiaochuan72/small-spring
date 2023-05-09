package cn.it.xiaodongbei.springstep02.factory.support;

import cn.it.xiaodongbei.springstep02.BeansException;
import cn.it.xiaodongbei.springstep02.factory.config.BeanDefinition;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: 自动装配Bean对象  实例化Bean类
 * @Version: 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            // 通过反射获取Bean对象
            bean  = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        // 加入到单例bean对象中
        addSingleton(beanName,bean);
        return bean;
    }
}
