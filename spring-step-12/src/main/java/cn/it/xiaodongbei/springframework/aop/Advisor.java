package cn.it.xiaodongbei.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  22:15
 * @Description: TODO
 * @Version: 1.0
 */
public interface Advisor {
    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
