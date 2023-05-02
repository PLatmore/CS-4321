package CS;

public class Product {
    private String name;
    private double price;
    private boolean foodItem;

    public Product(String name, double price, boolean foodItem) {
        this.name = name;
        this.price = price;
        this.foodItem = foodItem;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFoodItem() {
        return foodItem;
    }
}


