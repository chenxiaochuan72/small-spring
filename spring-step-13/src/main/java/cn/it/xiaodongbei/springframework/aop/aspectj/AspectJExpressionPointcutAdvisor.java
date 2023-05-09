package cn.it.xiaodongbei.springframework.aop.aspectj;

import cn.it.xiaodongbei.springframework.aop.Pointcut;
import cn.it.xiaodongbei.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-05  22:16
 * @Description: TODO
 * @Version: 1.0
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    public void setExpression(String expression){
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice){
        this.advice = advice;
    }

}
