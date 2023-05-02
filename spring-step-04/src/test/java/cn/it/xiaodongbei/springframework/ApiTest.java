package cn.it.xiaodongbei.springframework;

import cn.it.xiaodongbei.springframework.bean.UserDao;
import cn.it.xiaodongbei.springframework.bean.UserService;
import cn.it.xiaodongbei.springframework.factory.PropertyValue;
import cn.it.xiaodongbei.springframework.factory.PropertyValues;
import cn.it.xiaodongbei.springframework.factory.config.BeanDefinition;
import cn.it.xiaodongbei.springframework.factory.config.BeanReference;
import cn.it.xiaodongbei.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  16:00
 * @Description: TODO
 * @Version: 1.0
 */
public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册UserDao
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        // 3. UserService 设置属性
        PropertyValues propertyValues=new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        // 4. UserService 注入bean
        beanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class,propertyValues));
        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
