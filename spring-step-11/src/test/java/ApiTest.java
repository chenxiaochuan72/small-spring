import bean.IUserService;
import bean.UserService;
import bean.UserServiceInterceptor;
import cn.it.xiaodongbei.springframework.aop.AdvisedSupport;
import cn.it.xiaodongbei.springframework.aop.TargetSource;
import cn.it.xiaodongbei.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.it.xiaodongbei.springframework.aop.framework.JdkDynamicAopProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  20:58
 * @Description: TODO
 * @Version: 1.0
 */
public class ApiTest {
//    @Test
//    public void test_proxy_method(){
//        // 目标对象
//        Object targetObj=new UserService();
//
//        // AOP 代理
//
//        Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
//            // 方法匹配起
//
//            MethodMat
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                if ()
//            }
//        });
//    }
    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut=new AspectJExpressionPointcut("execution(* bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));

    }
    @Test
    public void test_dynamic(){
        // 目标对象
        IUserService userService=new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport=new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* bean.IUserService.*(..))"));

        // 代理对象
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();

        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());
//
//        // 代理对象(Cglib2AopProxy)
//        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
//
//        System.out.println("测试结果：" + proxy_cglib.register("花花"));

    }
}