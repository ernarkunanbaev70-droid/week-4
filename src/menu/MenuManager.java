package menu;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n1. Add Clothing Item");
        System.out.println("2. View Products");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addClothing();
                    case 2 -> viewProducts();
                    case 0 -> running = false;
                    default -> throw new InvalidInputException("Invalid menu choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            } catch (IllegalArgumentException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addClothing() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Size: ");
        String size = scanner.nextLine();

        products.add(new ClothingItem(name, price, size));
        System.out.println("Clothing item added!");
    }

    private void viewProducts() {
        for (Product p : products) {
            p.displayInfo();
        }
    }
}
