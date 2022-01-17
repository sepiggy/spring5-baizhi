package cn.sepiggy.aspect;

import com.baizhiedu.proxy.User;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
