package cn.it.xiaodongbei.springframework.aop;


/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  21:02
 * @Description:
 * 切入点接口，定义用于获取 ClassFilter、MethodMatcher 的两个类，这两个接口获取都是切点表达式提供的内容。
 * @Version: 1.0
 */
public interface Pointcut {
    /**
     * Return the ClassFilter for this pointcut.
     * @return the ClassFilter (never <code>null</code>)
     */
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     * @return the MethodMatcher (never <code>null</code>)
     */
    MethodMatcher getMethodMatcher();

}
