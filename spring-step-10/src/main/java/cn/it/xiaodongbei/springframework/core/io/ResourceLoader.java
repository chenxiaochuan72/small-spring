package cn.it.xiaodongbei.springframework.core.io;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  19:11
 * @Description: 包装资源加载器
 * 按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的类服务下进行处理，外部用户只需要传递资源地址
 * @Version: 1.0
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX="classpath:";
    Resource getResource(String location);
}
