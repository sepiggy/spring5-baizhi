package com.baizhiedu.proxy.a;

import com.baizhiedu.proxy.User;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
