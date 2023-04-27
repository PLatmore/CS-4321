package CommandLineInterface;
import java.util.Scanner;
import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Product> productList;
    private int numUniqueProducts;
    private double totalValue;

    public InventoryManager() {
        productList = new ArrayList<>();
        numUniqueProducts = 0;
        totalValue = 0;
    }

    public void addProduct(Product product) {
        productList.add(product);
        numUniqueProducts++;
        totalValue += product.getTotalPrice();
    }

    public void displayProducts() {
        sortProductsByName();

        System.out.println(String.format("%-10s%-20s%-20s%-10s%-10s%-20s%-10s", "Product ID", "Name", "Manufacturer", "Price", "Quantity", "Total Value", "Food Item"));
        System.out.println("----------------------------------------------------------------------------------------------");

        for (Product p : productList) {
            System.out.println(p.toString());
        }

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-30s%-10s", "Total Unique Products:", numUniqueProducts));
        System.out.println(String.format("%-30s%-10s", "Total Value:", "$" + totalValue));
    }

    public void sortProductsByName() {
        for (int i = 0; i < productList.size(); i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                Product pi = productList.get(i);
                Product pj = productList.get(j);

                if (pi.getProductId().compareTo(pj.getProductId()) > 0) {
                    productList.set(i, pj);
                    productList.set(j, pi);
                }
            }
        }
    }

    public void sortProductsByID() {
        for (int i = 0; i < productList.size(); i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                Product pi = productList.get(i);
                Product pj = productList.get(j);

                if (pi.getProductId().compareTo(pj.getProductId()) > 0) {
                    productList.set(i, pj);
                    productList.set(j, pi);
                }
            }
        }
    }

    public void sortProductsByManufacturer() {
        for (int i = 0; i < productList.size(); i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                Product pi = productList.get(i);
                Product pj = productList.get(j);

                if (pi.getManufacturer().compareTo(pj.getManufacturer()) > 0) {
                    productList.set(i, pj);
                    productList.set(j, pi);
                }
            }
        }
    }

    public void sortProductsByFoodItem() {
        for (int i = 0; i < productList.size(); i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                Product pi = productList.get(i);
                Product pj = productList.get(j);

                if (Boolean.compare(pi.isFoodItem(), pj.isFoodItem()) > 0) {
                    productList.set(i, pj);
                    productList.set(j, pi);
                }
            }
        }
    }




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InventoryManager productManager = new InventoryManager();

        while (true) {
            System.out.println("Enter product ID (4 digits) or 'done' to exit:");
            String productID = input.nextLine();
            if (productID.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter product name:");
            String productName = input.nextLine();

            System.out.println("Enter product manufacturer:");
            String productManufacturer = input.nextLine();
            System.out.println("Enter product price:");
            double productPrice = input.nextDouble();

            System.out.println("Enter product quantity:");
            int productQuantity = input.nextInt();

            System.out.println("Is this a food item? (Y/N):");
            String isFoodItemInput = input.next();
            boolean isFoodItem = false;
            if (isFoodItemInput.equalsIgnoreCase("Y")) {
                isFoodItem = true;
            }

            input.nextLine(); // clear input buffer

            Product newProduct = new Product(productID, productName, productManufacturer, productPrice, productQuantity, isFoodItem);
            productManager.addProduct(newProduct);

            System.out.println("Product added successfully!\n");
        }

        productManager.displayProducts();
    }

        
    }

