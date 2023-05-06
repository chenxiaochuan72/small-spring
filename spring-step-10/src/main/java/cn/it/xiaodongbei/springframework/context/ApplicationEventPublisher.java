package cn.it.xiaodongbei.springframework.context;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  00:22
 * @Description: TODO
 * @Version: 1.0
 */
public interface ApplicationEventPublisher {
    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);

}
