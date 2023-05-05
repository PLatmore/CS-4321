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
    
    // Order()
    public Order() {
        this.id = nextId++;
    }
    
    // getId()
    public int getId() {
        return id;
    }
    
    //addProduct(Product product)
    public void addProduct(Product product) {
        products.add(product);
        product.setQuantitySold(product.getQuantitySold() + 1);
        subtotal += product.getPrice();
        tax = subtotal * TAX_RATE;
        total = subtotal + tax;
    }

    //getProducts()
    public List<Product> getProducts() {
        return products;
    }
    
    // getSubtotal()
    public double getSubtotal() {
        return subtotal;
    }
    
    //getTax()
    public double getTax() {
        return tax;
    }
    
    //getTotal()
    public double getTotal() {
        return total;
    }
    
    //setPayment(Payment payment)
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    //findProductByName(String name)
    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
    
    //returnProduct(Product product)
    public boolean returnProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            recalculateTotals();
            return true;
        }
        return false;
    }
    
    //recalculateTotals()
    private void recalculateTotals() {
        subtotal = products.stream().mapToDouble(Product::getPrice).sum();
        tax = subtotal * TAX_RATE;
        total = subtotal + tax;
    }
}