package model;

public abstract class Product {

    protected String name;
    protected double price;

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public abstract String getCategory();

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void displayInfo() {
        System.out.println(getCategory() + ": " + name + " - " + price + " KZT");
    }
}
