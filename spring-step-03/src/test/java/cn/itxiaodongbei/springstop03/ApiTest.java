package cn.itxiaodongbei.springstop03;

import cn.itxiaodongbei.springstop03.bean.UserService;
import cn.itxiaodongbei.springstop03.factory.config.BeanDefinition;
import cn.itxiaodongbei.springstop03.factory.support.DefaultListableBeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  14:03
 * @Description: TODO
 * @Version: 1.0
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // 2. 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        factory.registerBeanDefinition("userService", beanDefinition);

        // 3. 获取Bean
        UserService bean = (UserService) factory.getBean("userService", "it小东北");
        bean.queryUserInfo();

        UserService singleton = (UserService) factory.getSingleton("userService");
        singleton.queryUserInfo();


    }

    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    //  验证有构造函数实例化
    @Test
    public void test_constructor() throws Exception {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("cxc");
        System.out.println(userService);
    }

    // 获取构造函数信息
    @Test
    public void test_parameterTypes() throws Exception {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<?> noConstructor = declaredConstructors[1];
        System.out.println(constructor);
        System.out.println(noConstructor);
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService itxiaodongbei = declaredConstructor.newInstance("cxc");
        System.out.println(itxiaodongbei);

        Constructor<UserService> declaredConstructor1 = beanClass.getDeclaredConstructor(noConstructor.getParameterTypes());
        UserService userService = declaredConstructor1.newInstance();
        userService.queryUserInfo();
    }
    @Test
    public void test_cglib(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object o = enhancer.create(new Class[]{String.class}, new Object[]{"itxiaodongbei"});
        System.out.println(o);

    }
}
