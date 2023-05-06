package cn.it.xiaodongbei.springframework.context.event;


import cn.it.xiaodongbei.springframework.context.ApplicationEvent;
import cn.it.xiaodongbei.springframework.context.ApplicationListener;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  00:04
 * @Description: TODO
 * @Version: 1.0
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
