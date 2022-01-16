package cn.sepiggy.advice;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);

}
