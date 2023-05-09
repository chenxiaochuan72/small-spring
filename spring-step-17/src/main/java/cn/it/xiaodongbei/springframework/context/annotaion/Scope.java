package cn.it.xiaodongbei.springframework.context.annotaion;

import java.lang.annotation.*;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-06  18:00
 * @Description: TODO
 * @Version: 1.0
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}
