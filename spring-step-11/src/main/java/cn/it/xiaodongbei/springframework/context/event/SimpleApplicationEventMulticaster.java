package cn.it.xiaodongbei.springframework.context.event;

import cn.it.xiaodongbei.springframework.beans.factory.BeanFactory;
import cn.it.xiaodongbei.springframework.context.ApplicationEvent;
import cn.it.xiaodongbei.springframework.context.ApplicationListener;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  00:25
 * @Description: TODO
 * @Version: 1.0
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
