package service;

import entity.Game;
import entity.Player;
import entity.Round;
import entity.Status;
import repository.GameRepository;

import java.util.List;

public class GameService {

    private final GameRepository gameRepository = new GameRepository();

    public Game findById(Integer id) {
        return gameRepository.findById(id);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public void initializeGame(Player player, Status status, Round round) {
        Game game = new Game();
        game.setStatus(status);
        game.setAccumulated(0);
        game.setPlayer(player);
        game.setRound(round);

        gameRepository.save(game);
    }

    public Game findActiveGame() {
        return gameRepository.findActive();
    }

    public void closeGames() {
        gameRepository.closeAllGames();
    }
}
