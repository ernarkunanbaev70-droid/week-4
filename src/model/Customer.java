package model;

public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        setName(name);
    }

    public Customer(String name) {
        this(0, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Customer name empty");
        this.name = name;
    }
}
