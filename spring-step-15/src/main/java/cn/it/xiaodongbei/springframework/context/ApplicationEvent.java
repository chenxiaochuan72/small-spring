package cn.it.xiaodongbei.springframework.context;

import java.util.EventObject;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  00:02
 * @Description: TODO
 * @Version: 1.0
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
