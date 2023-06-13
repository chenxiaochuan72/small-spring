package cn.it.xiaodongbei.springframework.context.support;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanPostProcessor;
import cn.it.xiaodongbei.springframework.context.ApplicationEvent;
import cn.it.xiaodongbei.springframework.context.ApplicationListener;
import cn.it.xiaodongbei.springframework.context.ConfigurableApplicationContext;
import cn.it.xiaodongbei.springframework.context.event.ApplicationEventMulticaster;
import cn.it.xiaodongbei.springframework.context.event.ContextRefreshedEvent;
import cn.it.xiaodongbei.springframework.context.event.SimpleApplicationEventMulticaster;
import cn.it.xiaodongbei.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
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
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";
    private ApplicationEventMulticaster applicationEventMulticaster;
    @Override
    public void refresh() throws BeansException {
        // 1. 创建BeanFactory 并加载BeanDefinition
        refreshBeanFactory();
        // 2。 获取BeanFacotry
        ConfigurableListableBeanFactory beanFactory=getBeanFactory();
        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
        // 5. 实现BeanPostProcessor接口的Bean 需要提前于其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 6. 初始化事件发布者
        initApplicationEventMulticaster();
        // 7. 注册事件监听器
        registerListeners();
        // 8. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
        // 9. 发布容器刷新完成事件
        finishRefresh();
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }
    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster=new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME,applicationEventMulticaster);
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

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
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
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name,requiredType);
    }
}
