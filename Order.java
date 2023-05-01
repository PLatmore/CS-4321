package CS;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Order {
    private static AtomicLong orderIdCounter = new AtomicLong(100000);
    private long id;
    private List<Product> products;

    public Order() {
        this.id = orderIdCounter.incrementAndGet();
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }

    public long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}