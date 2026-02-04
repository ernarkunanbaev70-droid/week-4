package menu;

import database.ProductDAO;
import model.ClothingItem;
import model.Product;

import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner sc = new Scanner(System.in);
    private final ProductDAO dao = new ProductDAO();

    @Override
    public void show() {
        System.out.println("""
            ===== PRODUCT MENU =====
            1. Add product
            2. Update price
            3. Delete product
            4. View ALL products (sorted by price)
            5. View ALL products (no sorting)
            6. View CLOTHING only
            7. Search by name
            8. Search by price range
            9. Search by min price
            0. Exit
            """);
    }

    @Override
    public void run() {
        while (true) {
            show();
            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> add();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> viewAllProducts();
                case 5 -> viewAllProductsUnsorted();
                case 6 -> viewClothingItems();
                case 7 -> searchByName();
                case 8 -> searchByPriceRange();
                case 9 -> searchByMinPrice();
                case 0 -> System.exit(0);
            }
        }
    }

    @Override
    public void viewAllProductsUnsorted() {
        for (Product p : dao.getAll()) {
            System.out.println(p.info());
        }
    }

    @Override
    public void viewAllProducts() {
        for (Product p : dao.getAllSortedByPrice()) {
            System.out.println(p.info());
        }
    }

    @Override
    public void viewClothingItems() {
        for (Product p : dao.getClothingItemsSorted()) {
            System.out.println(p.info());
        }
    }

    private void add() {
        System.out.print("Name: ");
        String n = sc.nextLine();

        System.out.print("Price: ");
        double p = Double.parseDouble(sc.nextLine());

        System.out.print("Size: ");
        String s = sc.nextLine();

        dao.add(new ClothingItem(n, p, s));
    }

    private void update() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("New price: ");
        double price = Double.parseDouble(sc.nextLine());

        if (dao.update(id, price)) {
            System.out.println("Updated");
        } else {
            System.out.println("Product not found");
        }
    }

    private void delete() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            if (dao.delete(id)) {
                System.out.println("Deleted");
            } else {
                System.out.println("Product not found");
            }
        } else {
            System.out.println("Cancelled");
        }
    }

    private void searchByName() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        for (Product p : dao.searchByName(name)) {
            System.out.println(p.info());
        }
    }

    private void searchByPriceRange() {
        System.out.print("Min price: ");
        double min = Double.parseDouble(sc.nextLine());

        System.out.print("Max price: ");
        double max = Double.parseDouble(sc.nextLine());

        for (Product p : dao.searchByPriceRange(min, max)) {
            System.out.println(p.info());
        }
    }

    private void searchByMinPrice() {
        System.out.print("Min price: ");
        double min = Double.parseDouble(sc.nextLine());

        for (Product p : dao.searchByMinPrice(min)) {
            System.out.println(p.info());
        }
    }
}
