package CS;

import java.util.*;

public class Store {
    private String name;
    private int id;
    private Map<Product, Integer> inventory;

    public Store(String name, int id) {
        this.name = name;
        this.id = id;
        this.inventory = new HashMap<>();
    }

    public void addToInventory(Product product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
    }

    public boolean hasProductInInventory(Product product) {
        return inventory.containsKey(product) && inventory.get(product) > 0;
    }

    public void removeFromInventory(Product product, int quantity) {
        if (hasProductInInventory(product)) {
            inventory.put(product, inventory.get(product) - quantity);
        }
    }

    public List<Product> searchProducts(String query) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : inventory.keySet()) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        matchingProducts.sort(Comparator.comparing(Product::getName));
        return matchingProducts;
    }

    public static void main(String[] args) {
        // Add sample products to store
        Store store = new Store("Super Store", 1);
        Product apple = new Product("Apple", 0.5, true);
        Product orange = new Product("Orange", 0.7, true);
        Product shirt = new Product("Shirt", 10, false);
        store.addToInventory(apple, 20);
        store.addToInventory(orange, 20);
        store.addToInventory(shirt, 10);

        // Search for products containing 'ap'
        List<Product> searchResults = store.searchProducts("ap");
        System.out.println("Search results for 'ap':");
        for (Product product : searchResults) {
            System.out.println(" - " + product.getName() + ": $" + product.getPrice());
        }
    }
}

