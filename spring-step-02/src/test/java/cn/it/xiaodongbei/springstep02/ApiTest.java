package cn.it.xiaodongbei.springstep02;

import cn.it.xiaodongbei.springstep02.bean.UserService;
import cn.it.xiaodongbei.springstep02.factory.config.BeanDefinition;
import cn.it.xiaodongbei.springstep02.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:52
 * @Description: TODO
 * @Version: 1.0
 */
public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
        // 2. 创建BeanDefinition
        BeanDefinition beanDefinition=new BeanDefinition(UserService.class);
        // 3. 注册BeanDefinition
        factory.registerBeanDefinition("userService",beanDefinition);

        // 4. 第一次获取bean
        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
        // 5. 第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) factory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
