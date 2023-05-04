package cn.it.xiaodongbei.springframework.context.support;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanPostProcessor;
import cn.it.xiaodongbei.springframework.context.ConfigurableApplicationContext;
import cn.it.xiaodongbei.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
*@Author: cxc
*@CreateTime: 2023-05-04  17:06
*@Description:
 * refresh() 定义实现过程，包括：
 * 创建 BeanFactory，并加载 BeanDefinition
 * 获取 BeanFactory
 * 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
 * BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
 * 提前实例化单例Bean对象
 * 另外把定义出来的抽象方法，refreshBeanFactory()、getBeanFactory() 由后面的继承此抽象类的其他抽象类实现。
*@Version: 1.0
*/
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext{
    @Override
    public void refresh() throws BeansException {
        // 1. 创建BeanFactory 并加载BeanDefinition
        refreshBeanFactory();
        
        // 2。 获取BeanFacotry
        ConfigurableListableBeanFactory beanFactory=getBeanFactory();
        
        // 3. 在Bean实例化之前，执行BeanFactoryPostProcessor 
        invokeBeanFactoryPostProcessors(beanFactory);
        
        // 4.BeanPostProcessor 需要提前于其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory();

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name,args);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name,requiredType);
    }
}
