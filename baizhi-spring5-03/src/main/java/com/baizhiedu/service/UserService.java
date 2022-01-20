package com.baizhiedu.service;

import com.baizhiedu.entity.User;

public interface UserService {

    void register(User user) throws Exception;

    void login(String name, String password);

}
