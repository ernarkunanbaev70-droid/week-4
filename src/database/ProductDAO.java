package database;

import model.ClothingItem;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void add(Product p) {
        String sql = """
                INSERT INTO products(name, price, size, category)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ClothingItem ci = (ClothingItem) p;

            ps.setString(1, ci.getName());
            ps.setDouble(2, ci.getPrice());
            ps.setString(3, ci.getSize());
            ps.setString(4, ci.getCategory());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ADD ERROR");
        }
    }

    public void update(int id, double price) {
        String sql = "UPDATE products SET price=? WHERE id=?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("UPDATE ERROR");
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id=?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("DELETE ERROR");
        }
    }

    public List<Product> getAllSortedByPrice() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY price";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new ClothingItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("size")
                ));
            }

        } catch (Exception e) {
            System.out.println("SELECT ERROR");
        }

        return list;
    }
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new ClothingItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("size")
                ));
            }

        } catch (Exception e) {
            System.out.println("SELECT ALL ERROR");
        }

        return list;
    }
    public List<Product> getClothingItemsSorted() {
        List<Product> list = new ArrayList<>();
        String sql = """
            SELECT * FROM products
            WHERE category = 'Clothing'
            ORDER BY price
            """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new ClothingItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("size")
                ));
            }

        } catch (Exception e) {
            System.out.println("SELECT CLOTHING ERROR");
        }

        return list;
    }

}
