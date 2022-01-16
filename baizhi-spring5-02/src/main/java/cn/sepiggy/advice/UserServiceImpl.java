package cn.sepiggy.advice;

public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UserServiceImpl.register");
        throw new RuntimeException("用户不存在，登陆错误");
    }

    @Override
    public boolean login(String name, String password) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
