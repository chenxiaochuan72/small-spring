import bean.UserService;
import cn.hutool.core.io.IoUtil;
import cn.it.xiaodongbei.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.it.xiaodongbei.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.it.xiaodongbei.springframework.core.io.DefaultResourceLoader;
import cn.it.xiaodongbei.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  20:22
 * @Description: TODO
 * @Version: 1.0
 */
public class ApiTest {
    @Test
    public void test_xml(){
        // 1. 初始化BeanFactroy
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();

        // 2. 读取配置文件并注册bean
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) factory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);


    }
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        // 网络原因可能导致GitHub不能读取，可以放到自己的Gitee仓库。读取后可以从内容中搜索关键字；OLpj9823dZ
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

}
