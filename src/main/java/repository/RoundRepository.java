package repository;

import connection.SqlConnection;
import entity.Round;

import java.sql.SQLException;

public class RoundRepository extends SqlConnection {

    private final Round round = new Round();
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final RewardRepository rewardRepository = new RewardRepository();

    public RoundRepository() {
        this.tableName = "rounds";
        this.key = "id";
    }

    @Override
    public Round findById(Integer id) {
        super.findById(id);
        return rowMapper();
    }

    private Round rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.round.setId(this.resultSet.getInt(1));
                this.round.setDescription(this.resultSet.getString(2));
                this.round.setCategory(categoryRepository.findById(this.resultSet.getInt(3)));
                this.round.setReward(rewardRepository.findById(this.resultSet.getInt(4)));
            }
            return this.round;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
