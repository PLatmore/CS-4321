package CS;

import java.util.List;
import java.util.Scanner;

public class Manager {
    private Inventory inventory;
    private List<Customer> customers;
    private Scanner scanner;

    public Manager(Inventory inventory, List<Customer> customers) {
        this.inventory = inventory;
        this.customers = customers;
        this.scanner = new Scanner(System.in);
    }

    public void addNewProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product manufacturer: ");
        String productManufacturer = scanner.nextLine();
        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter product quantity: ");
        int productQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Is this a food item? (yes/no): ");
        boolean isFoodItem = scanner.nextLine().equalsIgnoreCase("yes");

        Product product = new Product(productName, productManufacturer, productPrice, productQuantity, isFoodItem);
        inventory.addProduct(product);
    }

    public void displayProductReport() {
        System.out.println("\n--- Product Report ---");
        for (Product product : inventory.getProducts()) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Manufacturer: " + product.getManufacturer());
            System.out.printf("Price: $%.2f%n", product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Food Item: " + (product.isFoodItem() ? "Yes" : "No"));
            System.out.println();
        }
    }

    public void listCustomers() {
        System.out.println("\n--- Customer List ---");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Orders:");
                for (Order order : customer.getOrders()) {
                    System.out.println("  - Order ID: " + order.getId());
                }
                System.out.println();
            }
        }
    }
}


