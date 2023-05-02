package CS;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private Payment payment;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}

