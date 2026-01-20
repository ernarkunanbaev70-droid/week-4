package model;

public class Sale {

    private Customer customer;
    private Product product;

    public Sale(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
    }

    public void showSale() {
        System.out.print(customer.getName() + " bought ");
        product.displayInfo();
    }
}
