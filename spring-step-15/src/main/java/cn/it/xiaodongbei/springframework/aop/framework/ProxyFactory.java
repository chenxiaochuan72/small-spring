package cn.it.xiaodongbei.springframework.aop.framework;

import cn.it.xiaodongbei.springframework.aop.AdvisedSupport;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  22:31
 * @Description: TODO
 * @Version: 1.0
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public AdvisedSupport getAdvisedSupport() {
        return advisedSupport;
    }
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy(){
        if (advisedSupport.isProxyTargetClass()){
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
