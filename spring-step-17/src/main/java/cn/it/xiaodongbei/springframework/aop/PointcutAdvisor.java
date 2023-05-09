package cn.it.xiaodongbei.springframework.aop;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  22:15
 * @Description: TODO
 * @Version: 1.0
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
