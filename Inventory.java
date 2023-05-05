package Store;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;
    
    //Inventory()
    public Inventory() {
        products = new ArrayList<>();
    }	
    
    //addProduct(Product product)
    public void addProduct(Product product) {
        products.add(product);
    }
    
    //List<Product> getProducts()
    public List<Product> getProducts() {
        return products;
    }
    
    // findProductById(int id)
    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }	
    
    //deleteProductById(int id)
    public void deleteProductById(int id) {
        Product productToRemove = findProductById(id);
        if (productToRemove != null) {
            products.remove(productToRemove);
        }
    }
    
    //searchProducts(String searchTerm)
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