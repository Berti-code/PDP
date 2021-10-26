public class Transaction extends Inventory implements Runnable {
    private final Bill bill;
    private String name;
    private float totalPrice;
    private Boolean inventoryChanged;
    private Inventory deposit;

    public Transaction(Inventory deposit, String name, Bill bill) {
        this.deposit = deposit;
        this.name = name;
        this.bill = bill;
    }

    @Override
    public void run() {
        for (Product product : this.getProducts()){
            deposit.remove(product, this.getQuantity(product));
            System.out.println(this.name + ": took " + product.getProdName() + " -> " + String.valueOf(this.getQuantity(product)));
        }
    }

    @Override
    public void add(Product product, int quantity) {
        super.add(product, quantity);
        this.bill.add(product, quantity);
        inventoryChanged = true;
    }

    @Override
    public void remove(Product product, int quantity) {
        super.remove(product, quantity);
        inventoryChanged = true;
    }

    public float getTotalPrice() {
        if (inventoryChanged) {
            this.totalPrice = 0;
            for (Product product : this.getProducts()){
                this.totalPrice += this.getQuantity(product) * product.getUnitPrice();
            }
            this.inventoryChanged = false;
        }

        return this.totalPrice;
    }
}