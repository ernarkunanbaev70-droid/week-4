public class ClothingItem {
    protected int id;
    protected String name;
    protected String brand;
    protected double price;

    public ClothingItem(int id, String name, String brand, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public void show() {
        System.out.println(name + " | " + brand + " | " + price + " KZT");
    }

    public String type() {
        return "Clothing";
    }

    @Override
    public String toString() {
        return "[" + type() + "] " + name + ", " + brand + ", " + price + " KZT";
    }
}
