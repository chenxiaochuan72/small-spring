package cn.it.xiaodongbei.springframework.beans.factory.support;


import cn.hutool.core.bean.BeanUtil;
import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.PropertyValue;
import cn.it.xiaodongbei.springframework.beans.PropertyValues;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanReference;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: 自动装配Bean对象  实例化Bean类 创建调用策略
 * @Version: 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private InstantiationStrategy instantiationStrategy=new CglibSubclassingInstantiationStrategy();
    private InstantiationStrategy cglibStrategy=new SimpleInstantiationStrategy();

    public InstantiationStrategy getCglibStrategy() {
        return cglibStrategy;
    }

    public void setCglibStrategy(InstantiationStrategy cglibStrategy) {
        this.cglibStrategy = cglibStrategy;
    }

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
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
    /**
     * Bean 属性填充
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference){
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference= (BeanReference) value;
                    value=getBean(beanReference.getName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
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
//        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }
}
