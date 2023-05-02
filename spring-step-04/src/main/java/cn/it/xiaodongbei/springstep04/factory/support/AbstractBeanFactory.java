package cn.it.xiaodongbei.springstep04.factory.support;

import cn.it.xiaodongbei.springstep04.BeansException;
import cn.it.xiaodongbei.springstep04.factory.BeanFactory;
import cn.it.xiaodongbei.springstep04.factory.config.BeanDefinition;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: BeanDefinition 注册表接口 抽象类定义模板方法
 * @Version: 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    private Object doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (null!=bean){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException;


}
