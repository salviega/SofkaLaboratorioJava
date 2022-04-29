package repository;

import connection.SqlConnection;
import entity.Category;
import entity.Question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionRepository extends SqlConnection {

    private final Question question = new Question();
    private final CategoryRepository categoryRepository = new CategoryRepository();

    public QuestionRepository() {
        this.tableName = "questions";
        this.key = "id";
    }

    @Override
    public Question findById(Integer id) {
        super.findById(id);
        return this.rowMapper();
    }

    public List<Question> findAllByCategory(Category category) {
        List<Question> questions = new ArrayList<>();
        String query = String.format("SELECT * FROM %s WHERE category_id = %s",
                this.tableName,
                category.getId());
        try {
            this.preparedStatement = super.getConnection().prepareStatement(query);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()) {
                questions.add(new Question(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.categoryRepository.findById(this.resultSet.getInt(3))
                ));
            }
            return questions;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private Question rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.question.setId(this.resultSet.getInt(1));
                this.question.setDescription(this.resultSet.getString(2));
                this.question.setCategory(this.categoryRepository.findById(this.resultSet.getInt(3)));
            }
            return this.question;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
