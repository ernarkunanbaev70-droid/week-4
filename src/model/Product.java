package model;

public abstract class Product {
    protected int id;
    protected String name;
    protected double price;

    public Product(int id, String name, double price) {
        this.id = id;
        setName(name);
        setPrice(price);
    }

    public Product(String name, double price) {
        this(0, name, price);
    }

    public abstract String getCategory();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name empty");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price < 0");
        this.price = price;
    }

    public String info() {
        return id + " | " + name + " | " + price + " KZT";
    }
}
