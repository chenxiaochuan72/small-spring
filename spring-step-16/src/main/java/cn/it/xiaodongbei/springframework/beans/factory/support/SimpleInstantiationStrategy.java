package cn.it.xiaodongbei.springframework.beans.factory.support;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  13:14
 * @Description: JDK实例化
 * @Version: 1.0
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            // 判断 ctor 是否为空，如果为空则是无构造函数实例化，否则就是需要有构造函数的实例化
            if (null!=ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes())
                        .newInstance(args);
            }else {
                return clazz.newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
