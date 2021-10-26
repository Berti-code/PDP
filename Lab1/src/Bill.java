import java.util.HashMap;

public class Bill extends Inventory{
    private float totalPrice;
    private HashMap<Product, Integer> billProducts;

    public Bill() {
        this.totalPrice = 0;
        this.billProducts = new HashMap<>();
    }

    public void add(Product product, int quantity) {
        this.totalPrice += product.getUnitPrice() * quantity;
        this.billProducts.put(product, quantity);
    }

    public float getTotalPrice(){
        return this.totalPrice;
    }

    @Override
    public String toString() {
        System.out.println(this.totalPrice);
        return super.toString();
    }
}
