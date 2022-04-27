package repository;

import connection.SqlConnection;
import entity.Player;

import java.sql.SQLException;

public class PlayerRepository extends SqlConnection {

    private final Player player = new Player();

    public PlayerRepository() {
        this.tableName = "players";
        this.key = "id";
    }

    @Override
    public Player findById(Integer id) {
        super.findById(id);
        return this.rowMapper();
    }

    public void save(Player player) {
        String query = String.format("UPDATE %s SET age = %s, name = '%s' WHERE id = %s"
                + " IF @@ROWCOUNT = 0 INSERT INTO %s (id, age, name) VALUES (%s, %s, '%s')",
                this.tableName,
                player.getAge(),
                player.getName(),
                player.getId(),
                this.tableName,
                player.getId(),
                player.getAge(),
                player.getName());
        try {
            this.preparedStatement = super.getConnection().prepareStatement(query);
            this.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Player rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.player.setId(this.resultSet.getString(1));
                this.player.setAge(this.resultSet.getInt(2));
                this.player.setName(this.resultSet.getString(3));
            }
            return this.player;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
