package repository;

import connection.SqlConnection;
import entity.Category;


public class CategoryRepository extends SqlConnection {

    private final Category category = new Category();

    public CategoryRepository() {
        this.tableName = "categories";
        this.key = "id";
    }

    @Override
    public Category findById(Integer id) {
        super.findById(id);
        return this.rowMapper();
    }

    private Category rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.category.setId(this.resultSet.getInt(1));
                this.category.setDescription(this.resultSet.getString(2));
            }
            return this.category;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
