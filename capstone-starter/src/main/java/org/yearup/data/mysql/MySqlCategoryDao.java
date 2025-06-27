package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        // get all categories
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                categories.add(mapRow(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        String sql = "SELECT * FROM categories WHERE category_id = ?";
        Category category = null;


        // get category by id

        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                category = mapRow(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Category create(Category category) {
        // create a new category

        String sql = "INSERT INTO categories (name, description) VALUES (?, ?)";

        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    int newId = keys.getInt(1);
                    category.setCategoryId(newId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public Category update(int categoryId, Category category)
    {
        // update category

        String sql = "UPDATE categories SET name = ?, description = ? WHERE category_id = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, categoryId);
            stmt.setString(2, category.getName());
            stmt.setString(3, category.getDescription());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                category.setCategoryId(categoryId); // update the ID in the object
                return category;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public boolean delete(int categoryId)
    {
        // delete category
        String sql = "DELETE FROM categories WHERE category_id = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, categoryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
