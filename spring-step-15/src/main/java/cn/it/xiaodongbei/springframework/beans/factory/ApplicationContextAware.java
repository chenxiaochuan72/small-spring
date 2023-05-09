package cn.it.xiaodongbei.springframework.beans.factory;

import cn.it.xiaodongbei.springframework.beans.BeansException;
import cn.it.xiaodongbei.springframework.context.ApplicationContext;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  21:57
 * @Description:
 * Interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 * 实现此接口，既能感知到所属的 ApplicationContext
 * #
 * @Version: 1.0
 */
public interface ApplicationContextAware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
