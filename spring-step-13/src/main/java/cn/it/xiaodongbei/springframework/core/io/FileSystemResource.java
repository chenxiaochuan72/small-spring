package cn.it.xiaodongbei.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  19:02
 * @Description: 通过指定文件路径的方式读取文件信息，
 * @Version: 1.0
 */
public class FileSystemResource implements Resource{
    private final File file;
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }
    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }
}
