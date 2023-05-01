package cn.it.xiaodongbei.springstep01.test;

import cn.it.xiaodongbei.springstep01.BeanDefinition;
import cn.it.xiaodongbei.springstep01.BeanFactory;
import cn.it.xiaodongbei.springstep01.test.bean.UserService;
import org.junit.Test;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  19:08
 * @Description: TODO
 * @Version: 1.0
 */
public class ApiTest {
    @Test
    public void test_BeanFactroy(){
        // 1. 初始化beanFactory
        BeanFactory beanFactory=new BeanFactory();
        // 2. 注册Bean
        BeanDefinition beanDefinition=new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        // 3. 获取bean
        UserService userSerivice = (UserService) beanFactory.getBean("userSerivice");
        userSerivice.queryUserInfo();
    }
}
