package cn.it.xiaodongbei.springframework.context.event;

import cn.it.xiaodongbei.springframework.context.ApplicationContext;
import cn.it.xiaodongbei.springframework.context.ApplicationEvent;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  00:02
 * @Description: TODO
 * @Version: 1.0
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
