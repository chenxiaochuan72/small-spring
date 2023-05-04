package cn.it.xiaodongbei.springframework.context.support;

import cn.it.xiaodongbei.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  17:44
 * @Description: TODO
 * @Version: 1.0
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanFactory,this);
        String[] configLocations = getConfigLocations();
        if (null!=configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }
    protected abstract String[] getConfigLocations();
}
