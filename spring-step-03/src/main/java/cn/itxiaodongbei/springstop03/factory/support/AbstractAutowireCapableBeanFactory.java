package cn.itxiaodongbei.springstop03.factory.support;


import cn.itxiaodongbei.springstop03.BeansException;
import cn.itxiaodongbei.springstop03.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: 自动装配Bean对象  实例化Bean类 创建调用策略
 * @Version: 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private InstantiationStrategy instantiationStrategy=new CglibSubclassingInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean;
        try {
            bean  = createBeanInstance(beanDefinition,beanName,args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args){
        Constructor constructorToUse=null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructor = beanClass.getDeclaredConstructors();

        for (Constructor<?> ctor : declaredConstructor) {
            // 构造函数集合与入参信息 args 的匹配情况
            if (null!=args&&ctor.getParameterAnnotations().length==args.length){
                constructorToUse=ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }
}
