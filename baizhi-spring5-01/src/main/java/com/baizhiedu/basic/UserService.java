package com.baizhiedu.basic;

public interface UserService {

    void register(User user);

    void login(String name, String password);
}
