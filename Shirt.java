public class Shirt extends ClothingItem {
    private String size;
    
    public Shirt(String name, String brand, double price, String size) {
        super(name, brand, price);
        setSize(size);
    }
    public void setSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }
    @Override
    public String type() {
        return "Shirt";
    }
    @Override
    public void show() {
        System.out.println(type() + ": " + name + ", " + brand + ", $" + price + ", Size: " + size);
    }
}
