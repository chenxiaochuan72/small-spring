package cn.it.xiaodongbei.springstep04.factory.config;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: 单例注册接口定义和实现
 * @Version: 1.0
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String name);
}
