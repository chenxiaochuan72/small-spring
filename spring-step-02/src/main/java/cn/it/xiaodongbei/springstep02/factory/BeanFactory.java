package cn.it.xiaodongbei.springstep02.factory;

import cn.it.xiaodongbei.springstep02.BeansException;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:56
 * @Description: TODO
 * @Version: 1.0
 */
public interface BeanFactory {
    /**
     * 获取Bean对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;
}
