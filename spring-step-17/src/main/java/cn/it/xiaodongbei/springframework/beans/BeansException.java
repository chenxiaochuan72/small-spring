package cn.it.xiaodongbei.springframework.beans;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:56
 * @Description: TODO
 * @Version: 1.0
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
