package Store;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private Inventory inventory;
    private List<Customer> customers;
    private Scanner scanner;

  
    public Manager(Inventory inventory, List<Customer> customers) {
        this.inventory = inventory;
        this.customers = customers;
        scanner = new Scanner(System.in);
    }
    public void addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Is this a food item? (yes/no): ");
        boolean isFoodItem = scanner.nextLine().equalsIgnoreCase("yes");

        Product product = new Product(name, manufacturer, price, quantity, isFoodItem);
        inventory.addProduct(product);
    }

    public void displayProductReport() {
        System.out.println("\n--- Product Report ---");
        for (Product product : inventory.getProducts()) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Manufacturer: " + product.getManufacturer());
            System.out.printf("Price: $%.2f%n", product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Is food item: " + product.isFoodItem());
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

    public void changeProductPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product ID to change the price: ");
        int productId = scanner.nextInt();
        Product product = inventory.findProductById(productId);

        if (product != null) {
            System.out.printf("Current Price: $%.2f%n", product.getPrice());
            System.out.print("Enter the new price: ");
            double newPrice = scanner.nextDouble();
            product.setPrice(newPrice);
            System.out.println("Price updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void deleteProduct() {
        System.out.print("Enter the product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Product product = inventory.findProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
        } else {
            inventory.deleteProductById(productId);
            System.out.println("Product deleted successfully.");
        }
    }
    public void importProductsFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] productData = line.split(",");
                String name = productData[0].trim();
                String manufacturer = productData[1].trim();
                double price = Double.parseDouble(productData[2].trim());
                int quantity = Integer.parseInt(productData[3].trim());
                boolean isFoodItem = Boolean.parseBoolean(productData[4].trim());

                Product product = new Product(name, manufacturer, price, quantity, isFoodItem);
                inventory.addProduct(product);
            }

            System.out.println("Products imported successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void exportInventoryToFile(String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            List<Product> products = inventory.getProducts();

            for (Product product : products) {
                String productLine = String.format("%s, %s, %.2f, %d, %b%n",
                        product.getName(),
                        product.getManufacturer(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.isFoodItem());
                writer.write(productLine);
            }

            System.out.println("Inventory exported successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

