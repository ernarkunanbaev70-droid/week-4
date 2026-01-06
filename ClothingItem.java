public class ClothingItem {
    protected String name;
    protected String brand;
    protected double price;

    public ClothingItem(String name, String brand, double price) {
        setName(name);
        setBrand(brand);
        setPrice(price);
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.brand = brand;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }
    public String type() {
        return "Clothing Item";
    }
    public void show() {
        System.out.println(type() + ": " + name + ", " + brand + ", $" + price);
    }
    @Override
    public String toString() {
        return type() + ": " + name + ", " + brand + ", $" + price;
    }
}
