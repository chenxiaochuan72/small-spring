package cn.it.xiaodongbei.springframework.context.event;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  00:03
 * @Description: TODO
 * @Version: 1.0
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
