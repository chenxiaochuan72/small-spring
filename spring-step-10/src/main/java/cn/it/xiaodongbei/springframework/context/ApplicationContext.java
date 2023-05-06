package cn.it.xiaodongbei.springframework.context;

import cn.it.xiaodongbei.springframework.beans.factory.HierarchicalBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.ListableBeanFactory;
import cn.it.xiaodongbei.springframework.core.io.ResourceLoader;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  17:01
 * @Description: TODO
 * @Version: 1.0
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
