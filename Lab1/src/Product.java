public class Product {
    private String prodName;
    private float unitPrice;

    public Product(String prodName, float unitPrice){
        this.prodName = prodName;
        this.unitPrice = unitPrice;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
