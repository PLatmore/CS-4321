package CS;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
