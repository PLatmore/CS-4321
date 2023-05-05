package Store;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Manager {
    private Inventory inventory;
    private List<Customer> customers;
    private Scanner scanner;
    
    // Manager(Inventory inventory, List<Customer> customers)
    public Manager(Inventory inventory, List<Customer> customers) {
        this.inventory = inventory;
        this.customers = customers;
        scanner = new Scanner(System.in);
    }
    
    //addNewProduct()
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
        scanner.nextLine(); 
        System.out.print("Is this a food item? (yes/no): ");
        boolean isFoodItem = scanner.nextLine().equalsIgnoreCase("yes");

        Product product = new Product(name, manufacturer, price, quantity, isFoodItem);
        inventory.addProduct(product);
    }
    
    //displayProductReport()
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
    
    //listCustomers()
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
    
    //changeProductPrice()
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
    
    //deleteProduct()
    public void deleteProduct() {
        System.out.print("Enter the product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); 

        Product product = inventory.findProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
        } else {
            inventory.deleteProductById(productId);
            System.out.println("Product deleted successfully.");
        }
    }
    
    //importProductsFromFile(String filePath)
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
    
    //displayOrderStatistics()
    public void displayOrderStatistics() {
        int numOfOrders = 0;
        double totalRevenue = 0;
        double totalTaxes = 0;
        double taxRate = 0.05; 

        for (Customer customer : customers) {
            List<Order> orders = customer.getOrders();
            numOfOrders += orders.size();

            for (Order order : orders) {
                totalRevenue += order.getTotal();
                totalTaxes += order.getTax();
            }
        }

        double averageOrder = numOfOrders == 0 ? 0 : totalRevenue / numOfOrders;

        double variance = 0;
        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                variance += Math.pow(order.getTotal() - averageOrder, 2);
            }
        }
        variance /= numOfOrders;
        double standardDeviation = Math.sqrt(variance);

        System.out.println("\n--- Order Statistics ---");
        System.out.println("Number of Orders: " + numOfOrders);
        System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
        System.out.printf("Average Order: $%.2f%n", averageOrder);
        System.out.printf("Standard Deviation: $%.2f%n", standardDeviation);
        System.out.printf("Total Taxes Collected: $%.2f%n", totalTaxes);
    }
    
    //exportInventoryToFile(String filePath)
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
    
    //displayMostPopularProducts()
    public void displayMostPopularProducts() {
        List<Product> sortedProducts = new ArrayList<>(inventory.getProducts());
        sortedProducts.sort(Comparator.comparing(Product::getQuantitySold).reversed());

        System.out.println("Most Popular Products (Descending):");
        System.out.printf("%-25s %-20s %-10s %-10s %-10s\n", "Product Name", "Manufacturer", "Price", "Stock", "Quantity Sold");
        for (Product product : sortedProducts) {
            System.out.printf("%-25s %-20s %-10.2f %-10d %-10d\n",
                    product.getName(), product.getManufacturer(), product.getPrice(),
                    product.getStock(), product.getQuantitySold());
        }
    }
}
