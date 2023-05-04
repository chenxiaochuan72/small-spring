package cn.it.xiaodongbei.springframework.beans.factory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  22:45
 * @Description: TODO
 * @Version: 1.0
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
