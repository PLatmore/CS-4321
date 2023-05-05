package Store;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();
    private double storeCredit;
    
    //Customer(String name)
    public Customer(String name) {
        this.name = name;
    }
    
    //getName()
    public String getName() {
        return name;
    }
    
    //addOrder(Order order)
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    //getOrders()
    public List<Order> getOrders() {
        return orders;
    }
    
    //findOrderById(int id)
    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
    
    //addStoreCredit(double credit)
    public void addStoreCredit(double credit) {
        this.storeCredit += credit;
    }
    
    // getStoreCredit()
    public double getStoreCredit() {
        return storeCredit;
    }
}
