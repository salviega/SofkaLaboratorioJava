package repository;

import connection.SqlConnection;
import entity.Reward;

import java.sql.SQLException;

public class RewardRepository extends SqlConnection {

    private final Reward reward = new Reward();

    public RewardRepository() {
        this.tableName = "rewards";
        this.key = "id";
    }

    @Override
    public Reward findById(Integer id) {
        super.findById(id);
        return rowMapper();
    }

    private Reward rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.reward.setId(this.resultSet.getInt(1));
                this.reward.setDescription(this.resultSet.getString(2));
            }
            return this.reward;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
