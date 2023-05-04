package Store;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1;
    private final int id;
    private List<Product> products = new ArrayList<>();
    private double subtotal;
    private double tax;
    private double total;
    private Payment payment;

    private static final double TAX_RATE = 0.07;

    public Order() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public void addProduct(Product product) {
        products.add(product);
        subtotal += product.getPrice();
        tax = subtotal * TAX_RATE;
        total = subtotal + tax;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean returnProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            recalculateTotals();
            return true;
        }
        return false;
    }

    private void recalculateTotals() {
        // Update the subtotal, tax, and total after a product has been returned
        subtotal = products.stream().mapToDouble(Product::getPrice).sum();
        tax = subtotal * TAX_RATE;
        total = subtotal + tax;
    }
}
