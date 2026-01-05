import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<ClothingItem> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int c;

        do {
            System.out.println("\n1 Add clothing");
            System.out.println("2 Add shirt");
            System.out.println("3 Add jacket");
            System.out.println("4 Show all");
            System.out.println("5 Show shirts");
            System.out.println("6 Show jackets");
            System.out.println("0 Exit");
            System.out.print("> ");

            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1 -> addItem();
                case 2 -> addShirt();
                case 3 -> addJacket();
                case 4 -> showAll();
                case 5 -> showShirts();
                case 6 -> showJackets();
            }

        } while (c != 0);
    }

    static void addItem() {
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String brand = sc.nextLine();
        double price = sc.nextDouble();
        sc.nextLine();
        list.add(new ClothingItem(id, name, brand, price));
    }

    static void addShirt() {
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String brand = sc.nextLine();
        double price = sc.nextDouble();
        sc.nextLine();
        String size = sc.nextLine();
        list.add(new Shirt(id, name, brand, price, size));
    }

    static void addJacket() {
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String brand = sc.nextLine();
        double price = sc.nextDouble();
        sc.nextLine();
        boolean winter = sc.nextBoolean();
        sc.nextLine();
        list.add(new Jacket(id, name, brand, price, winter));
    }

    static void showAll() {
        for (ClothingItem x : list) {
            x.show();
        }
    }

    static void showShirts() {
        for (ClothingItem x : list) {
            if (x instanceof Shirt) {
                System.out.println(x);
            }
        }
    }

    static void showJackets() {
        for (ClothingItem x : list) {
            if (x instanceof Jacket) {
                System.out.println(x);
            }
        }
    }
}
