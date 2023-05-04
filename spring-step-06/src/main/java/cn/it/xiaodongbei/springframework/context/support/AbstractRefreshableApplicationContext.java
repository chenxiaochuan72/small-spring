package cn.it.xiaodongbei.springframework.context.support;

import cn.it.xiaodongbei.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  17:26
 * @Description: 获取Bean工厂和加载资源
 * @Version: 1.0
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() {
        DefaultListableBeanFactory beanFactory=createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory=beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
