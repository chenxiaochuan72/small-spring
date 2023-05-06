package cn.it.xiaodongbei.springframework.beans.factory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  21:01
 * @Description: TODO
 * @Version: 1.0
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
