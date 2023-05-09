package cn.it.xiaodongbei.springstep02.factory.support;

import cn.it.xiaodongbei.springstep02.BeansException;
import cn.it.xiaodongbei.springstep02.factory.BeanFactory;
import cn.it.xiaodongbei.springstep02.factory.config.BeanDefinition;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: BeanDefinition 注册表接口 抽象类定义模板方法
 * @Version: 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        // 首先查看是否已经创建了bean对象
        Object bean = getSingleton(name);
        if (bean!=null){
            return bean;
        }
        // 通过名称获取对应的 BeanDefinition
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 通过name 和BeanDefinition 创建Bean对象
        return createBean(name,beanDefinition);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;


}
