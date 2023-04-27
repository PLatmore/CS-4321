package CommandLineInterface;

public class Product {
    private String productId;
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private boolean isFoodItem;

    public Product(String productId, String name, String manufacturer, double price, int quantity, boolean isFoodItem) {
        this.productId = productId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.isFoodItem = isFoodItem;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isFoodItem() {
        return isFoodItem;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        String foodItemStr = isFoodItem ? "Yes" : "No";
        return String.format("%-10s%-20s%-20s$%-10.2f%-10d$%-20.2f%-10s", productId, name, manufacturer, price, quantity, getTotalPrice(), foodItemStr);
    }
}
