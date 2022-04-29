package repository;

import connection.SqlConnection;
import entity.AnswerOption;
import entity.Question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerOptionRepository extends SqlConnection {

    private final AnswerOption answerOption = new AnswerOption();
    private final QuestionRepository questionRepository = new QuestionRepository();

    public AnswerOptionRepository() {
        this.tableName = "answer_options";
        this.key = "id";
    }

    @Override
    public AnswerOption findById(Integer id) {
        super.findById(id);
        return this.rowMapper();
    }

    public List<AnswerOption> findAllByQuestion(Question question) {
        List<AnswerOption> answerOptions = new ArrayList<>();
        String query = String.format("SELECT * FROM %s WHERE question_id = %s", this.tableName, question.getId());
        try {
            this.preparedStatement = super.getConnection().prepareStatement(query);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()) {
                answerOptions.add(new AnswerOption(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.resultSet.getBoolean(3),
                        this.questionRepository.findById(this.resultSet.getInt(4))
                ));
            }
            return answerOptions;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private AnswerOption rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.answerOption.setId(this.resultSet.getInt(1));
                this.answerOption.setDescription(this.resultSet.getString(2));
                this.answerOption.setValid(this.resultSet.getBoolean(3));
                this.answerOption.setQuestion(questionRepository.findById(this.resultSet.getInt(4)));
            }
            return this.answerOption;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
