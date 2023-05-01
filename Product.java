package CS;

public class Product {
    private String name;
    private double price;
    private boolean isFoodItem;

    public Product(String name, double price, boolean isFoodItem) {
        this.name = name;
        this.price = price;
        this.isFoodItem = isFoodItem;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFoodItem() {
        return isFoodItem;
    }
}