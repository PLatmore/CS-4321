package Store;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private String name;
    private int id;
    private Scanner scanner;

    private List<Customer> customers = new ArrayList<>();
    private Inventory inventory;
    private Manager manager;

    public Store(String name, int id) {
        this.name = name;
        this.id = id;
        this.inventory = new Inventory();
        this.manager = new Manager(inventory, customers);
        scanner = new Scanner(System.in);
    }
    private void displayAvailableProducts() {
        System.out.println("\n--- Available Products ---");
        List<Product> availableProducts = inventory.getProducts();
        if (availableProducts.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : availableProducts) {
                System.out.println("Product Name: " + product.getName());
                System.out.println("Manufacturer: " + product.getManufacturer());
                System.out.printf("Price: $%.2f%n", product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println();
            }
        }
    }
    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    
    public void handleProductReturn() {
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        Customer customer = findCustomerByName(customerName);

        if (customer == null) {
            System.out.println("No customer found with that name.");
            return;
        }

        System.out.print("Enter the order ID of the order containing the product you want to return: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        Order order = customer.findOrderById(orderId);

        if (order == null) {
            System.out.println("No order found with that ID.");
            return;
        }

        System.out.print("Enter the name of the product you want to return: ");
        String productName = scanner.nextLine();
        Product productToReturn = order.findProductByName(productName);

        if (productToReturn == null) {
            System.out.println("No product found with that name.");
            return;
        }

        if (order.returnProduct(productToReturn)) {
            double returnedAmount = productToReturn.getPrice();
            customer.addStoreCredit(returnedAmount);
            inventory.addProduct(productToReturn); // Restock the returned product
            System.out.printf("Product returned successfully. You now have $%.2f in store credit.%n", customer.getStoreCredit());
        } else {
            System.out.println("Failed to return the product.");
        }
    }
    
    private void searchAndDisplayProducts() {
        System.out.print("Enter a product name or part of a name to search: ");
        String searchTerm = scanner.nextLine();
        List<Product> matchingProducts = inventory.searchProducts(searchTerm);

        if (matchingProducts.isEmpty()) {
            System.out.println("No products found matching your search.");
        } else {
            System.out.println("\n--- Matching Products ---");
            for (Product product : matchingProducts) {
                System.out.println("Product Name: " + product.getName());
                System.out.println("Manufacturer: " + product.getManufacturer());
                System.out.printf("Price: $%.2f%n", product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println();
            }
        }
    }
    
    public void processOrder() {
    	displayAvailableProducts(); 
    	 System.out.print("Do you want to search for a product? (yes/no): ");
         boolean searchProduct = scanner.nextLine().equalsIgnoreCase("yes");
         if (searchProduct) {
             searchAndDisplayProducts();
         }
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        customers.add(customer);

        Order order = new Order();
        boolean addMoreProducts = true;

        while (addMoreProducts) {
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
            order.addProduct(product);

            System.out.print("Add more products? (yes/no): ");
            addMoreProducts = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.print("Do you want to use SNAP? (yes/no): ");
        boolean useSnap = scanner.nextLine().equalsIgnoreCase("yes");

        Payment payment = new Payment(order, useSnap);
        order.setPayment(payment);
        customer.addOrder(order);

        printReceipt(customer, order);
    }

    private void printReceipt(Customer customer, Order order) {
        System.out.println("\n--- Receipt ---");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Order ID: " + order.getId());
        System.out.println("Products:");
        for (Product product : order.getProducts()) {
            System.out.printf("  - %s ($%.2f)%n", product.getName(), product.getPrice());
        }
        System.out.printf("Subtotal: $%.2f%n", order.getSubtotal());
        System.out.printf("Tax: $%.2f%n", order.getTax());
        System.out.printf("Total: $%.2f%n", order.getTotal());
    }

    public void viewPreviousOrders(Customer customer) {
        System.out.println("\n--- Previous Orders ---");
        for (Order order : customer.getOrders()) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Products:");
            for (Product product : order.getProducts()) {
                System.out.printf("  - %s ($%.2f)%n", product.getName(), product.getPrice());
            }
            System.out.printf("Subtotal: $%.2f%n", order.getSubtotal());
            System.out.printf("Tax: $%.2f%n", order.getTax());
            System.out.printf("Total: $%.2f%n%n", order.getTotal());
        }
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to " + name + "!");
            System.out.println("1. Manager");
            System.out.println("2. Customer");
            System.out.println("3. Product Return");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 1) {
                handleManagerActions();
            } else if (choice == 2) {
                processOrder();
            } else if (choice == 3) {
                handleProductReturn();
            } else if (choice == 4) {
                System.out.println("Thank you for using our system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleManagerActions() {
        while (true) {
            System.out.println("\nManager Actions:");
            System.out.println("1. Add New Product");
            System.out.println("2. Display Product Report");
            System.out.println("3. Display Customer List");
            System.out.println("4. Change Product Price");
            System.out.println("5. Delete Product");
            System.out.println("6. Import Products from File");
            System.out.println("7. Export Inventory to File");
            System.out.println("8. Return to Main Menu");
            System.out.print("Please select an action (1-8): ");
            int action = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (action == 1) {
                manager.addNewProduct();
            } else if (action == 2) {
                manager.displayProductReport();
            } else if (action == 3) {
                manager.listCustomers();
            } else if (action == 4) {
                manager.changeProductPrice();
            } else if (action == 5) {
                manager.deleteProduct();
            } else if (action == 6) {
                System.out.print("Enter the path to the file to import products from: ");
                String filePath = scanner.nextLine();
                manager.importProductsFromFile(filePath);
            } else if (action == 7) {
                System.out.print("Enter the path to the file to export inventory to: ");
                String filePath = scanner.nextLine();
                manager.exportInventoryToFile(filePath);
            } else if (action == 8) {
                break;
            } else {
                System.out.println("Invalid action. Please try again.");
            }
        }
    }



    public static void main(String[] args) {
        Store store = new Store("Super Store", 1);
        store.start();
    }
}