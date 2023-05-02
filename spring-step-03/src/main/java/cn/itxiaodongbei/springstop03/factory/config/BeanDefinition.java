package cn.itxiaodongbei.springstop03.factory.config;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:55
 * @Description: TODO
 * @Version: 1.0
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
