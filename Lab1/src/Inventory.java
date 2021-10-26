import java.util.HashMap;
import java.util.Set;

public class Inventory {
    private HashMap<Product, Integer> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void add(Product product, int quantity){
        if (this.products.containsKey(product)){
            this.products.replace(product, this.products.get(product) + quantity);
        } else {
            this.products.put(product, quantity);
        }
    }

    public void remove(Product product, int quantity){
        if (this.products.containsKey(product)){
            if (this.getQuantity(product) < quantity){
                throw new RuntimeException("Product quantity is low!");
            }
        }
    }

    public Set<Product> getProducts(){
        return this.products.keySet();
    }

    public int getQuantity(Product product) {
        return this.products.getOrDefault(product, 0);
    }

    @Override
    public String toString() {
        StringBuilder ss = new StringBuilder();
        for (Product product : this.getProducts()){
            ss.append("(").append(product.getProdName()).append(", ").append(this.getQuantity(product)).append(")\n");
        }

        return ss.toString();
    }
}
