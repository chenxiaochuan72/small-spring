package cn.it.xiaodongbei.springframework.beans.factory.support;

import cn.it.xiaodongbei.springframework.core.io.DefaultResourceLoader;
import cn.it.xiaodongbei.springframework.core.io.ResourceLoader;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  19:32
 * @Description: Bean定义抽象类实现
 * @Version: 1.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
