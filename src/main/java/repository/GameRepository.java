package repository;

import connection.SqlConnection;
import entity.Game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRepository extends SqlConnection {

    private final Game game = new Game();
    private final PlayerRepository playerRepository = new PlayerRepository();
    private final RoundRepository roundRepository = new RoundRepository();
    private final StatusRepository statusRepository = new StatusRepository();


    public GameRepository() {
        this.tableName = "games";
        this.key = "id";
    }

    @Override
    public Game findById(Integer id) {
        super.findById(id);
        return this.rowMapper();
    }

    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", this.tableName);
        try {
            this.preparedStatement = super.getConnection().prepareStatement(query);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()) {
                games.add(new Game(
                        this.resultSet.getInt(1),
                        this.resultSet.getInt(2),
                        statusRepository.findById(this.resultSet.getInt(5)),
                        roundRepository.findById(this.resultSet.getInt(4)),
                        playerRepository.findById(this.resultSet.getInt(3))
                ));
            }
            return games;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Game findActive() {
        String query = String.format("SELECT * FROM %s WHERE status_id = 1", this.tableName);
        try {
            this.preparedStatement = super.getConnection().prepareStatement(query);
            this.resultSet = this.preparedStatement.executeQuery();
            return this.rowMapper();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Game game) {
        String query = String.format("INSERT INTO games (accumulated, player_id, round_id, status_id) VALUES (%s, %s, %s, %s)",
                game.getAccumulated(),
                game.getPlayer().getId(),
                game.getRound().getId(),
                game.getStatus().getId());
        try {
            this.preparedStatement = super.getConnection().prepareStatement(query);
            this.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeAllGames() {
        String query = String.format("UPDATE %s SET status_id = 3 WHERE status_id = 1", this.tableName);
        try {
            this.preparedStatement = super.getConnection().prepareStatement(query);
            this.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Game rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.game.setId(this.resultSet.getInt(1));
                this.game.setAccumulated(this.resultSet.getInt(2));
                this.game.setPlayer(playerRepository.findById(this.resultSet.getInt(3)));
                this.game.setRound(roundRepository.findById(this.resultSet.getInt(4)));
                this.game.setStatus(statusRepository.findById(this.resultSet.getInt(5)));
            }
            return this.game;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
