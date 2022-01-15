package cn.sepiggy.proxy.v2_dynamicproxy_spring;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
