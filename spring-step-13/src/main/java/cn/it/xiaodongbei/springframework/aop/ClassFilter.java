package cn.it.xiaodongbei.springframework.aop;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  21:04
 * @Description:
 * 定义类匹配类，用于切点找到给定的接口和目标类。
 * @Version: 1.0
 */
public interface ClassFilter {
    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);

}
