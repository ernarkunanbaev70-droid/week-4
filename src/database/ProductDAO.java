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

    public boolean update(int id, double price) {
        String sql = "UPDATE products SET price=? WHERE id=?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM products WHERE id=?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
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
        }

        return list;
    }

    public List<Product> searchByName(String name) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name ILIKE ? ORDER BY name";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ClothingItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("size")
                ));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<Product> searchByPriceRange(double min, double max) {
        List<Product> list = new ArrayList<>();
        String sql = """
                SELECT * FROM products
                WHERE price BETWEEN ? AND ?
                ORDER BY price DESC
                """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ClothingItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("size")
                ));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<Product> searchByMinPrice(double min) {
        List<Product> list = new ArrayList<>();
        String sql = """
                SELECT * FROM products
                WHERE price >= ?
                ORDER BY price DESC
                """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ClothingItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("size")
                ));
            }

        } catch (Exception e) {
        }

        return list;
    }
}
