package cn.it.xiaodongbei.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  18:37
 * @Description: 主要用于处理资源加载流。
 * @Version: 1.0
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
