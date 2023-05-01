package CS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Store {
    private String name;
    private int id;
	private Scanner scanner;

    public Store(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void processOrder() {
        scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        new Customer(customerName);

        Order order = new Order();
        boolean addMoreProducts = true;

        while (addMoreProducts) {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter product price: ");
            double productPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            System.out.print("Is this a food item? (yes/no): ");
            boolean isFoodItem = scanner.nextLine().equalsIgnoreCase("yes");
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            Product product = new Product(productName, productPrice, isFoodItem);
            order.addProduct(product, quantity);

            System.out.print("Do you want to add more products? (yes/no): ");
            addMoreProducts = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.print("Do you want to pay for the order with SNAP? (yes/no): ");
        boolean isUsingSnap = scanner.nextLine().equalsIgnoreCase("yes");

        // Payment and receipt
        Payment payment = new Payment(order, isUsingSnap);
        System.out.println("\nRECEIPT");
        System.out.println("Store Name: " + name);
        System.out.println("Store ID: " + id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Date: " + LocalDateTime.now().format(formatter));
        System.out.println("\nItems Purchased:");
        for (Product product : order.getProducts()) {
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice() + ", Is Food Item: " + (product.isFoodItem() ? "Yes" : "No"));
        }
        if (isUsingSnap) {
            System.out.printf("SNAP Total: $%.2f%n", payment.getSnapTotal());
            System.out.printf("Non-Food Subtotal: $%.2f%n", payment.getNonFoodSubtotal());
        } else {
            System.out.printf("Subtotal: $%.2f%n", order.calculateTotal());
        }
        System.out.printf("Tax: $%.2f%n", payment.getTax());
        System.out.printf("Grand Total: $%.2f%n", payment.getGrandTotal());
        System.out.println("\nThank you for your purchase!");
    }

    public static void main(String[] args) {
        Store store = new Store("Example Store", 12345);
        store.processOrder();
    }
}
