package cn.it.xiaodongbei.springframework.beans.factory;

import cn.it.xiaodongbei.springframework.beans.BeansException;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  21:56
 * @Description: TODO
 * Interface to be implemented by beans that wish to be aware of their owning {@link BeanFactory}.
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 * @Version: 1.0
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
