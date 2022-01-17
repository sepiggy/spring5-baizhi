package cn.sepiggy.proxy.dynamicproxy_spring;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
