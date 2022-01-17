package cn.sepiggy.proxy.staticproxy;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
