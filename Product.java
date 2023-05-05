package Store;


public class Product {
    private static int nextId = 1000;
    
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private boolean isFoodItem;
    private int quantitySold;
    
    //Product(String name, String manufacturer, double price, int quantity, boolean isFoodItem)
    public Product(String name, String manufacturer, double price, int quantity, boolean isFoodItem) {
        this.id = nextId++;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.isFoodItem = isFoodItem;
    }
    
    //getManufacturer()
    public String getManufacturer() {
        return manufacturer;
    }
    
    //setManufacturer(String manufacturer)
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    //getPrice()
    public double getPrice() {
        return price;
    }
    
    //setPrice(double price)
    public void setPrice(double price) {
        this.price = price;
    }
    
    // getQuantity()
    public int getQuantity() {
        return quantity;
    }
    
    //setQuantity(int quantity)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //getId()
    public int getId() {
        return id;
    }

    //getName()
    public String getName() {
        return name;
    }
    
    //setName(String name)
    public void setName(String name) {
        this.name = name;
    }

    //isFoodItem()
    public boolean isFoodItem() {
        return isFoodItem;
    }
    
    //setFoodItem(boolean isFoodItem)
    public void setFoodItem(boolean isFoodItem) {
        this.isFoodItem = isFoodItem;
    }
    
    //getQuantitySold()
    public int getQuantitySold() {
        return quantitySold;
    }
    
    //setQuantitySold(int quantitySold)
    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
    
    //getStock()
    public int getStock() {
        return quantity;
    }
}