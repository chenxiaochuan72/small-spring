package cn.it.xiaodongbei.springframework.context;

import java.util.EventListener;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  00:05
 * @Description: TODO
 * @Version: 1.0
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}

