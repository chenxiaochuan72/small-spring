package cn.it.xiaodongbei.springstep04.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  15:52
 * @Description: TODO
 * @Version: 1.0
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
