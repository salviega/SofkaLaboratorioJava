package service;

import entity.AnswerOption;
import entity.Game;
import entity.Player;

public class PlayService {

    private final GameService gameService = new GameService();
    private final PlayerService playerService = new PlayerService();
    private final StatusService statusService = new StatusService();
    private final RoundService roundService = new RoundService();

    public void startGame(Player player) {
        playerService.save(player);
        gameService.closeGames();
        gameService.initializeGame(player, statusService.findById(1), roundService.findById(1));
    }

    public Game controlGame(AnswerOption answerOption) {
        Game activeGame = gameService.findActiveGame();
        if(activeGame.getRound().getId() < 5) {
            if (Boolean.TRUE.equals(answerOption.getValid())) {
                return continueGame(activeGame);
            } else {
                return loseGame(activeGame);
            }
        } else {
            if (Boolean.TRUE.equals(answerOption.getValid())) {
                return winGame(activeGame);
            } else {
                return loseGame(activeGame);
            }
        }
    }

    public Game continueGame(Game game) {
        game.setAccumulated(game.getAccumulated() + game.getRound().getReward().getAmount());
        game.setRound(roundService.findById((game.getRound().getId() + 1)));
        return gameService.save(game);
    }

    public Game finishGame(Game game) {
        if(game.getStatus().getId() == 1) {
            game.setStatus(statusService.findById(2));
        }
        return gameService.save(game);
    }

    public Game winGame(Game game) {
        game.setStatus(statusService.findById(5));
        return gameService.save(game);
    }

    public Game loseGame(Game game) {
        game.setStatus(statusService.findById(4));
        game.setAccumulated(0);
        return gameService.save(game);
    }
}
