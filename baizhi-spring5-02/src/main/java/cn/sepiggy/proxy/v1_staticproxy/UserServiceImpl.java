package cn.sepiggy.proxy.v1_staticproxy;

public class UserServiceImpl implements UserService{

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }

}
