package cn.it.xiaodongbei.springframework.beans.factory.support;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.core.io.Resource;
import cn.it.xiaodongbei.springframework.core.io.ResourceLoader;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  19:24
 * @Description: TODO
 * @Version: 1.0
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String... locations) throws BeansException;

}

