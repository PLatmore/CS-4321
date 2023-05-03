package CS;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1000;

    private int id;
    private List<Product> products = new ArrayList<>();
    private Payment payment;

    public Order() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.getPrice();
        }
        return subtotal;
    }

    public double getTax() {
        if (payment != null) {
            return payment.calculateTax();
        }
        return 0;
    }

    public double getTotal() {
        if (payment != null) {
            return payment.calculateTotal();
        }
        return 0;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
