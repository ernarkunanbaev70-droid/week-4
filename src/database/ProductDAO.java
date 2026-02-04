public Product findById(int id) {
    String sql = "SELECT * FROM products WHERE id = ?";
    try (Connection c = DatabaseConnection.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new ClothingItem(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("size")
            );
        }
    } catch (Exception e) {
    }
    return null;
}
