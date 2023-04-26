package CommandLineInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    inventory.addProduct(name, quantity);
                    System.out.println("Added " + quantity + " " + name + " to inventory.");
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        }
    }
}

class Inventory {
    private Map<String, Integer> products = new HashMap<>();

    public void addProduct(String name, int quantity) {
        if (products.containsKey(name)) {
            products.put(name, products.get(name) + quantity);
        } else {
            products.put(name, quantity);
        }
    }
}