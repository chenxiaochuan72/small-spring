package cn.it.xiaodongbei.springstep01;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  18:42
 * @Description: TODO
 * @Version: 1.0
 */
public class BeanFactory {
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<>();

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
