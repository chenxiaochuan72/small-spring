package cn.it.xiaodongbei.springframework.core.convert.convert;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-06  21:26
 * @Description: TODO
 * @Version: 1.0
 */
public interface Converter<S,T> {
    /** Convert the source object of type {@code S} to target type {@code T}. */
    T convert(S source);
}
