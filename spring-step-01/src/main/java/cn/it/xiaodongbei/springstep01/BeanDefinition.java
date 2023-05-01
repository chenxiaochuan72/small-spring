package cn.it.xiaodongbei.springstep01;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  18:42
 * @Description: TODO
 * @Version: 1.0
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
