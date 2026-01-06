public class Jacket extends ClothingItem {
    private boolean winter;

    public Jacket(String name, String brand, double price, boolean winter) {
        super(name, brand, price);
        this.winter = winter;
    }
    public void setWinter(boolean winter) {
        this.winter = winter;
    }
    @Override
    public String type() {
        return "Jacket";
    }
    @Override
    public void show() {
        System.out.println(type() + ": " + name + ", " + brand + ", $" + price + ", Winter: " + winter);
    }
}
