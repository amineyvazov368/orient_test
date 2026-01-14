package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private Connection connection = null;

    public CategoryDao() {
        try {
            String url = "jdbc:postgresql://localhost:5432/learn_db";
            String userName = "postgres";
            String password = "postgres";
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void createCategory(String categoryName, String description) {
        try {
            String insertCategory = "insert  into categories ( category_name, description) values ('" + categoryName + "', '" + description + "')";
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(insertCategory);
            if (count > 0) {
                System.out.println("Category " + categoryName + " created");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Category> getAllCategory() {
        try {
            List<Category> categories = new ArrayList<>();
            Statement statement = connection.createStatement();
            String query = "select category_id, category_name,description from categories";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                Category category = new Category(id, name, description);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
        return null;
    }

    public Category getCategoryById(String id) {
        try {
            String query = "select * from categories where category_id= ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long categoryId = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                Category category = new Category(categoryId, name, description);
                return category;
            }
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
        return null;
    }

    public Category deleteCategory(String id) {
        Category category = getCategoryById(id);
        if (category == null) {
            return null;
        }
        try {
            String query = "delete from categories where category_id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            System.out.println("Category_id  " + id + " deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    public Category updateCategory(String categoryName, String description, String id) {
        Category category1 = getCategoryById(id);
        if (category1 == null) {
            return null;
        }
        try {
            String query = "update categories set category_name=?, description=? where category_id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, categoryName);
            preparedStatement.setString(2, description);
            preparedStatement.setLong(3, Long.parseLong(id));
            preparedStatement.executeUpdate();
            category1.setName(categoryName);
            category1.setDescription(description);
            System.out.println("Category_id  " + id + " updated");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
        return category1;
    }
}
