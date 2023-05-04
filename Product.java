package CS;

public class Product {
    private static int nextId = 1000;
    
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private boolean isFoodItem;
    private int quantitySold;

    // Update the constructor to match the one used in the Store class
    public Product(String name, String manufacturer, double price, int quantity, boolean isFoodItem) {
        this.id = nextId++;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.isFoodItem = isFoodItem;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isFoodItem() {
        return isFoodItem;
    }

    public void setFoodItem(boolean isFoodItem) {
        this.isFoodItem = isFoodItem;
    }
    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
    public int getStock() {
        return quantity;
    }
}
