package model;

public class ClothingItem extends Product implements Discountable {

    private String size;

    public ClothingItem(String name, double price, String size) {
        super(name, price);
        setSize(size);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    public void setSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("Size cannot be empty");
        }
        this.size = size;
    }

    @Override
    public double getDiscountedPrice() {
        return price * 0.9;
    }
}
