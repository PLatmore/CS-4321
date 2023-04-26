package CommandLineInterface;
import java.util.Scanner;

public class CommandLineInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "hello":
                    System.out.println("Hello, world!");
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