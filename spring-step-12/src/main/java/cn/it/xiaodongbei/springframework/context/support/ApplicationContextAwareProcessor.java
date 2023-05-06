package cn.it.xiaodongbei.springframework.context.support;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.factory.ApplicationContextAware;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanPostProcessor;
import cn.it.xiaodongbei.springframework.context.ApplicationContext;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  21:59
 * @Description: TODO
 * @Version: 1.0
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return  bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
