package Store;

public class ProductTests {

    //public static void main(String[] args) {
        //testGetAndSetManufacturer();
        //testGetAndSetPrice();
        //testGetAndSetQuantity();
        //testGetAndSetName();
        //testGetAndSetIsFoodItem();
        //testGetAndSetQuantitySold();
        //testGetStock();
    //}
    
    //createTestProduct()
    public static Product createTestProduct() {
        return new Product("Test Product", "Test Manufacturer", 10.0, 20, true);
    }
    
    //testGetAndSetManufacturer()
    public static void testGetAndSetManufacturer() {
        Product product = createTestProduct();
        String newManufacturer = "New Test Manufacturer";
        product.setManufacturer(newManufacturer);

        if (!product.getManufacturer().equals(newManufacturer)) {
            System.out.println("Failed: testGetAndSetManufacturer");
        } else {
            System.out.println("Passed: testGetAndSetManufacturer");
        }
    }
    
    //testGetAndSetPrice()
    public static void testGetAndSetPrice() {
        Product product = createTestProduct();
        double newPrice = 12.0;
        product.setPrice(newPrice);

        if (product.getPrice() != newPrice) {
            System.out.println("Failed: testGetAndSetPrice");
        } else {
            System.out.println("Passed: testGetAndSetPrice");
        }
    }
    
    //testGetAndSetQuantity()
    public static void testGetAndSetQuantity() {
        Product product = createTestProduct();
        int newQuantity = 25;
        product.setQuantity(newQuantity);

        if (product.getQuantity() != newQuantity) {
            System.out.println("Failed: testGetAndSetQuantity");
        } else {
            System.out.println("Passed: testGetAndSetQuantity");
        }
    }
    
    //testGetAndSetName()
    public static void testGetAndSetName() {
        Product product = createTestProduct();
        String newName = "New Test Product";
        product.setName(newName);

        if (!product.getName().equals(newName)) {
            System.out.println("Failed: testGetAndSetName");
        } else {
            System.out.println("Passed: testGetAndSetName");
        }
    }
    
    //testGetAndSetIsFoodItem()
    public static void testGetAndSetIsFoodItem() {
        Product product = createTestProduct();
        boolean newIsFoodItem = false;
        product.setFoodItem(newIsFoodItem);

        if (product.isFoodItem() != newIsFoodItem) {
            System.out.println("Failed: testGetAndSetIsFoodItem");
        } else {
            System.out.println("Passed: testGetAndSetIsFoodItem");
        }
    }	
    
    //testGetAndSetQuantitySold()
    public static void testGetAndSetQuantitySold() {
        Product product = createTestProduct();
        int newQuantitySold = 5;
        product.setQuantitySold(newQuantitySold);

        if (product.getQuantitySold() != newQuantitySold) {
            System.out.println("Failed: testGetAndSetQuantitySold");
        } else {
            System.out.println("Passed: testGetAndSetQuantitySold");
        }
    }
    
    //testGetStock()
    public static void testGetStock() {
        Product product = createTestProduct();

        if (product.getStock() != product.getQuantity()) {
            System.out.println("Failed: testGetStock");
        } else {
            System.out.println("Passed: testGetStock");
        }
    }
}