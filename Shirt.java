public class Shirt extends ClothingItem {
    private String size;

    public Shirt(int id, String name, String brand, double price, String size) {
        super(id, name, brand, price);
        this.size = size;
    }

    @Override
    public void show() {
        System.out.println("Shirt: " + name + " | size: " + size + " | " + price + " KZT");
    }

    @Override
    public String type() {
        return "Shirt";
    }
}
