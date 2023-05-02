package cn.itxiaodongbei.springstop03.factory.support;

import cn.itxiaodongbei.springstop03.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-01  21:56
 * @Description: TODO
 * @Version: 1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String,Object> singletonObjects=new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }
    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }
}
