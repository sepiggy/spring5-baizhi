package cn.sepiggy.proxy.v1_staticproxy;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceProxy();
        userService.login("sepiggy", "12345");
        userService.register(new User());

        System.out.println("-------------------------------------------");

        OrderService orderService = new OrderServiceImpl();
        orderService.showOrder();
    }

}
