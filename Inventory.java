package CS;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    
    public void deleteProductById(int id) {
        Product productToRemove = findProductById(id);
        if (productToRemove != null) {
            products.remove(productToRemove);
        }
    }
    
    public List<Product> searchProducts(String searchTerm) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

}