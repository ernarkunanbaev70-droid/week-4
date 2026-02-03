package model;

public class ClothingItem extends Product implements Discountable {

    private String size;

    public ClothingItem(int id, String name, double price, String size) {
        super(id, name, price);
        setSize(size);
    }

    public ClothingItem(String name, double price, String size) {
        super(name, price);
        setSize(size);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size == null || size.isBlank())
            throw new IllegalArgumentException("Size empty");
        this.size = size;
    }

    @Override
    public double getDiscountedPrice() {
        return price * 0.9;
    }

    @Override
    public String info() {
        return super.info() + " | size: " + size;
    }
}
