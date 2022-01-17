package cn.sepiggy.proxy.dynamicproxy_jdk;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
