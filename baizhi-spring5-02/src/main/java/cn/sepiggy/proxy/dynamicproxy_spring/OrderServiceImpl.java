package cn.sepiggy.proxy.dynamicproxy_spring;

public class OrderServiceImpl implements OrderService {

    @Override
    public void showOrder() {
        System.out.println("OrderServiceImpl.showOrder");
    }

}
