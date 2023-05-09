package cn.it.xiaodongbei.springframework.beans.factory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  21:55
 * @Description: TODO
 * @Version: 1.0
 */
/**
 * Marker superinterface indicating that a bean is eligible to be
 * notified by the Spring container of a particular framework object
 * through a callback-style method.  Actual method signature is
 * determined by individual subinterfaces, but should typically
 * consist of just one void-returning method that accepts a single
 * argument.
 *
 * 标记类接口，实现该接口可以被Spring容器感知
 *
 */
public interface Aware {
}
