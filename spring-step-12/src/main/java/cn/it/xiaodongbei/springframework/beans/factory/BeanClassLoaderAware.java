package cn.it.xiaodongbei.springframework.beans.factory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  21:56
 * @Description:
 * Callback that allows a bean to be aware of the bean{@link ClassLoader class loader}; that is, the class loader used by the present bean factory to load bean classes.
 * 实现此接口，既能感知到所属的 ClassLoader
 * #
 * @Version: 1.0
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);

}
