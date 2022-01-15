package cn.sepiggy.proxy.v1_staticproxy;

public class OrderServiceProxy implements OrderService{

    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("-----log-----");
        System.out.println("OrderServiceProxy.showOrder");
    }

}
