package Store;

import java.util.List;

public class OrderTests {

    //public static void main(String[] args) {
        //testAddProduct();
        //testFindProductByName();
        //testReturnProduct();
    //}
    
    //createTestOrder()
    public static Order createTestOrder() {
        Order order = new Order();
        Product product1 = new Product("Apple", "Apple Inc.", 1.99, 10, false);
        Product product2 = new Product("Banana", "Banana Corp.", 0.99, 15, false);
        order.addProduct(product1);
        order.addProduct(product2);
        return order;
    }
    
    //testAddProduct()
    public static void testAddProduct() {
        Order order = new Order();
        Product product = new Product("Orange", "Orange Inc.", 0.75, 20, false);
        order.addProduct(product);

        List<Product> products = order.getProducts();
        if (products.size() != 1 || !products.contains(product)) {
            System.out.println("Failed: testAddProduct");
        } else {
            System.out.println("Passed: testAddProduct");
        }
    }
    
    //testFindProductByName()
    public static void testFindProductByName() {
        Order order = createTestOrder();
        Product foundProduct = order.findProductByName("Apple");

        if (foundProduct == null || !foundProduct.getName().equals("Apple")) {
            System.out.println("Failed: testFindProductByName");
        } else {
            System.out.println("Passed: testFindProductByName");
        }
    }
    
    //testReturnProduct()
    public static void testReturnProduct() {
        Order order = createTestOrder();
        Product productToReturn = order.findProductByName("Apple");
        boolean isReturned = order.returnProduct(productToReturn);

        if (!isReturned || order.getProducts().contains(productToReturn)) {
            System.out.println("Failed: testReturnProduct");
        } else {
            System.out.println("Passed: testReturnProduct");
        }
    }
}