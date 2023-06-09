package cn.it.xiaodongbei.springframework.beans.factory.support;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  13:23
 * @Description: Cglib实例化
 * @Version: 1.0
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null==ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
