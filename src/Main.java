import database.ProductDAO;
import model.ClothingItem;
import model.Product;

import java.util.Scanner;

public class Main {

    private static final ProductDAO productDAO = new ProductDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    1. Add product
                    2. View all products
                    3. Update product price
                    4. Delete product
                    5. Search by name
                    6. Search by price range
                    7. Search by min price
                    0. Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> productDAO.getAll().forEach(System.out::println);
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> searchByName();
                case 6 -> searchByPriceRange();
                case 7 -> searchByMinPrice();
                case 0 -> System.exit(0);
            }
        }
    }

    private static void addProduct() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Size: ");
        String size = scanner.nextLine();

        Product p = new ClothingItem(name, price, size);
        productDAO.add(p);
    }

    private static void updateProduct() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();

        System.out.print("New price: ");
        double price = scanner.nextDouble();

        productDAO.update(id, price);
    }

    private static void deleteProduct() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            productDAO.delete(id);
        }
    }

    private static void searchByName() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        productDAO.searchByName(name).forEach(System.out::println);
    }

    private static void searchByPriceRange() {
        System.out.print("Min price: ");
        double min = scanner.nextDouble();

        System.out.print("Max price: ");
        double max = scanner.nextDouble();

        productDAO.searchByPriceRange(min, max).forEach(System.out::println);
    }

    private static void searchByMinPrice() {
        System.out.print("Min price: ");
        double min = scanner.nextDouble();
        productDAO.searchByMinPrice(min).forEach(System.out::println);
    }
}
