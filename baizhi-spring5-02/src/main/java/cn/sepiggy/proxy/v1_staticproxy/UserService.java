package cn.sepiggy.proxy.v1_staticproxy;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
