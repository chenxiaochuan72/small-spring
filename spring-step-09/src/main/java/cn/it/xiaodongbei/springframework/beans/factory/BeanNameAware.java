package cn.it.xiaodongbei.springframework.beans.factory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  21:57
 * @Description:
 * 实现此接口，既能感知到所属的 BeanName
 * @Version: 1.0
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
