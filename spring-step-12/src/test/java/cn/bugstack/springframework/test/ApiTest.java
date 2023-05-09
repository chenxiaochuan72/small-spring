package cn.bugstack.springframework.test;

import cn.bugstack.springframework.test.bean.IUserService;
import cn.it.xiaodongbei.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ApiTest {


    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
