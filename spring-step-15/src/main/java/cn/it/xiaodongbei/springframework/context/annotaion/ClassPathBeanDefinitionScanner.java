package cn.it.xiaodongbei.springframework.context.annotaion;

import cn.hutool.core.util.StrUtil;
import cn.it.xiaodongbei.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import cn.it.xiaodongbei.springframework.beans.factory.config.BeanDefinition;
import cn.it.xiaodongbei.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.it.xiaodongbei.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-06  18:08
 * @Description: TODO
 * @Version: 1.0
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider{
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages){
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton、prototype
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        registry.registerBeanDefinition("cn.it.xiaodongbei.springframework.context.annotation.internalAutowiredAnnotationProcessor", new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));

    }

    private String resolveBeanScope(BeanDefinition beanDefinition){
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (scope!=null){
            return scope.value();
        }
        return StrUtil.EMPTY;
    }
    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
