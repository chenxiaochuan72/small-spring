package cn.it.xiaodongbei.springframework.context.annotaion;

import cn.hutool.core.util.ClassUtil;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanDefinition;
import cn.it.xiaodongbei.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-06  18:04
 * @Description: TODO
 * @Version: 1.0
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackge){
        Set<BeanDefinition> candidates=new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackge, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
