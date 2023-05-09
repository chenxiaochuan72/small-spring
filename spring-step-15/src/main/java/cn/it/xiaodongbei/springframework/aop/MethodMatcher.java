package cn.it.xiaodongbei.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  21:03
 * @Description: 方法匹配，找到表达式范围内匹配下的目标类和方法
 * @Version: 1.0
 */
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
