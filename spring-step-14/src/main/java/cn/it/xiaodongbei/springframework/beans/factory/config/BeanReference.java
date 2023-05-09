package cn.it.xiaodongbei.springframework.beans.factory.config;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  15:48
 * @Description: TODO
 * @Version: 1.0
 */
public class BeanReference {
    private final String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
