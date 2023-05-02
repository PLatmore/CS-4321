package CS;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products;
    private Payment payment;

    public Order(int id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
