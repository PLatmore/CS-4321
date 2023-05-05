package Store;
import java.util.List;

public class InventoryTests {
	
	//public static void main(String[] args) {
        //testAddProduct();
        //testFindProductById();
        //testDeleteProductById();
       //testSearchProducts();
        //testInventoryScenario();
        //System.out.println("All tests finished.");
    //}
	
	//testAddProduct()
    public static void testAddProduct() {
        Inventory inventory = new Inventory();
        Product product = new Product("Apple", "Apple Inc.", 1.99, 10, false);
        inventory.addProduct(product);
        if (inventory.getProducts().size() != 1) {
            System.out.println("Failed: testAddProduct");
        }
    }
    
    //testFindProductById()
    public static void testFindProductById() {
        Inventory inventory = new Inventory();
        Product product = new Product("Apple", "Apple Inc.", 1.99, 10, false);
        inventory.addProduct(product);
        int productId = product.getId();
        if (inventory.findProductById(productId) != product) {
            System.out.println("Failed: testFindProductById");
        }
    }
    
    //testDeleteProductById()
    public static void testDeleteProductById() {
        Inventory inventory = new Inventory();
        Product product = new Product("Apple", "Apple Inc.", 1.99, 10, false);
        inventory.addProduct(product);
        int productId = product.getId();
        inventory.deleteProductById(productId);
        if (inventory.getProducts().size() != 0) {
            System.out.println("Failed: testDeleteProductById");
        }
    }
    
    //testSearchProducts()
    public static void testSearchProducts() {
        Inventory inventory = new Inventory();
        Product product1 = new Product("Apple", "Apple Inc.", 1.99, 10, false);
        Product product2 = new Product("Banana", "Banana Corp.", 0.99, 15, false);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        List<Product> results = inventory.searchProducts("apple");
        if (results.size() != 1 || !results.contains(product1)) {
            System.out.println("Failed: testSearchProducts");
        }
    }

    public static void testInventoryScenario() {
        // Create an inventory
        Inventory inventory = new Inventory();

        // Add products
        Product product1 = new Product("Apple", "Apple Inc.", 1.99, 10, false);
        Product product2 = new Product("Banana", "Banana Corp.", 0.99, 15, false);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Verify products
        if (inventory.getProducts().size() != 2) {
            System.out.println("Failed: product count");
        }
        if (inventory.findProductById(product1.getId()) != product1) {
            System.out.println("Failed: find product1");
        }
        if (inventory.findProductById(product2.getId()) != product2) {
            System.out.println("Failed: find product2");
        }

        // Search products
        List<Product> results = inventory.searchProducts("apple");
        if (results.size() != 1 || !results.contains(product1)) {
            System.out.println("Failed: search product");
        }

        // Delete product
        inventory.deleteProductById(product1.getId());
        if (inventory.getProducts().size() != 1) {
            System.out.println("Failed: delete product");
        }
    }

}