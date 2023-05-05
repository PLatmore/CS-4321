package Store;

import java.util.ArrayList;
import java.util.List;

public class ManagerTests {

    //public static void main(String[] args) {
        //testAddNewProduct();
        //testDeleteProduct();
        //testChangeProductPrice();
   // }
    
    //createTestInventory()
    public static Inventory createTestInventory() {
        Inventory inventory = new Inventory();
        Product product1 = new Product("Apple", "Apple Inc.", 1.99, 10, false);
        Product product2 = new Product("Banana", "Banana Corp.", 0.99, 15, false);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        return inventory;
    }
    
    //createTestCustomers()
    public static List<Customer> createTestCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");
        customers.add(customer1);
        customers.add(customer2);
        return customers;
    }
    
    //testAddNewProduct()
    public static void testAddNewProduct() {
        Inventory inventory = createTestInventory();
        List<Customer> customers = createTestCustomers();
        Manager manager = new Manager(inventory, customers);
        manager.addNewProduct();

        if (inventory.getProducts().size() != 3) {
            System.out.println("Failed: testAddNewProduct");
        } else {
            System.out.println("Passed: testAddNewProduct");
        }
    }
    
    //testDeleteProduct()
    public static void testDeleteProduct() {
        Inventory inventory = createTestInventory();
        List<Customer> customers = createTestCustomers();
        Manager manager = new Manager(inventory, customers);
        manager.deleteProduct();

        if (inventory.getProducts().size() != 1) {
            System.out.println("Failed: testDeleteProduct");
        } else {
            System.out.println("Passed: testDeleteProduct");
        }
    }
    
    //testChangeProductPrice()
    public static void testChangeProductPrice() {
        Inventory inventory = createTestInventory();
        List<Customer> customers = createTestCustomers();
        Manager manager = new Manager(inventory, customers);
        manager.changeProductPrice();
        Product product = inventory.findProductById(1);
        if (product.getPrice() != 2.99) {
            System.out.println("Failed: testChangeProductPrice");
        } else {
            System.out.println("Passed: testChangeProductPrice");
        }
    }
}