import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private List<Product> products;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.getPrice();
        }
        return subtotal;
    }

    public double calculateTotal() {
        double total = calculateSubtotal();
        if (hasFoodProducts()) {
            total *= 1.04;
        } else {
            total *= 1.08;
        }
        return total;
    }

    private boolean hasFoodProducts() {
        for (Product product : products) {
            if (product.isFood()) {
                return true;
            }
        }
        return false;
    }
}
