package CS;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private String name;
    private int id;
    private Scanner scanner;

    // Add a list of customers
    private List<Customer> customers = new ArrayList<>();

    public Store(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void processOrder() {
        scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        customers.add(customer);

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

            Product product = new Product(productName, productPrice, isFoodItem);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\n--- Receipt ---");
        System.out.println("Store: " + name + " | Store ID: " + id);
        System.out.println("Date: " + now.format(formatter));
        System.out.println("Customer: " + customer.getName());
        System.out.println("\nItems Purchased:");
        for (Product product : order.getProducts()) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println("\nSNAP Total: $" + order.getPayment().getSnapTotal());
        System.out.println("Non-Food Subtotal: $" + order.getPayment().getNonFoodSubtotal());
        System.out.println("Tax: $" + order.getPayment().getTax());
        System.out.println("Grand Total: $" + order.getPayment().getGrandTotal());
    }
    public void viewPreviousOrders(Customer customer) {
        List<Order> orders = customer.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No previous orders found.");
            return;
        }

        // Sort orders in descending order
        orders.sort((o1, o2) -> o2.getPayment().getPaymentTimestamp().compareTo(o1.getPayment().getPaymentTimestamp()));

        System.out.println("Previous orders:");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". Order #" + (i + 1) + " - " + orders.get(i).getPayment().getPaymentTimestamp());
        }

        System.out.print("Select an order to view the receipt (1-" + orders.size() + "): ");
        int orderIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline left-over

        if (orderIndex >= 0 && orderIndex < orders.size()) {
            printReceipt(customer, orders.get(orderIndex));
        } else {
            System.out.println("Invalid order selection.");
        }
    }

    public static void main(String[] args) {
        Store store = new Store("Super Store", 1);
        store.processOrder();
        // Call viewPreviousOrders() after processing an order, assuming there is at least one customer
        if (!store.customers.isEmpty()) {
            store.viewPreviousOrders(store.customers.get(0));
        }
    }
}