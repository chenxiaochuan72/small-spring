package bean;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-04  23:33
 * @Description: TODO
 * @Version: 1.0
 */
public class UserService {
    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public IUserDao getUserDao() {
        return userDao;
    }
}
