package cn.itxiaodongbei.springstop03.bean;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  14:03
 * @Description: TODO
 * @Version: 1.0
 */
public class UserService {
    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
