package cn.it.xiaodongbei.springframework.context;

import cn.it.xiaodongbei.springframework.beans.BeansException;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  17:01
 * @Description: TODO
 * @Version: 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
