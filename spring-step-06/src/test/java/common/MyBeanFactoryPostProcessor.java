package common;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.beans.PropertyValue;
import cn.it.xiaodongbei.springframework.beans.PropertyValues;
import cn.it.xiaodongbei.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanDefinition;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  18:16
 * @Description: TODO
 * @Version: 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
