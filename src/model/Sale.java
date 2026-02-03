package model;

public class Sale {
    private int id;
    private Product product;
    private int quantity;

    public Sale(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        setQuantity(quantity);
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity <= 0");
        this.quantity = quantity;
    }
}
