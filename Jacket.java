public class Jacket extends ClothingItem {
    private boolean winter;

    public Jacket(int id, String name, String brand, double price, boolean winter) {
        super(id, name, brand, price);
        this.winter = winter;
    }

    @Override
    public void show() {
        System.out.println("Jacket: " + name + " | winter: " + winter + " | " + price + " KZT");
    }

    @Override
    public String type() {
        return "Jacket";
    }
}
