package controller;

import entity.AnswerOption;
import entity.Game;
import entity.Player;
import entity.Question;
import service.AnswerOptionService;
import service.GameService;
import service.PlayService;
import service.QuestionService;
import util.Methods;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PlayController {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        AnswerOptionService answerOptionService = new AnswerOptionService();
        PlayService playService = new PlayService();
        GameService gameService = new GameService();
        QuestionService questionService = new QuestionService();

        Player player = new Player();

        player.setId(JOptionPane.showInputDialog("Ingrese su identificador (Numeros)"));
        player.setName(JOptionPane.showInputDialog("Ingrese su Nombre"));
        player.setAge(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad")));

        playService.startGame(player);

        Game game = gameService.findActiveGame();

        //List<Game> games = gameService.findAll();

        //Methods.showGameHistory(games);

        while (game.getStatus().getDescription().equals("Activo")) {
            if (game.getRound().getId() > 1) {
                int continueGame = JOptionPane.showConfirmDialog(null, "Su puntaje es de: "
                        + game.getAccumulated() + ", Desea continuar?",
                        "Continuar?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (continueGame == 1) {
                    game = playService.finishGame(game);
                    Methods.showMessages(game);
                    continue;
                }
            }
            Question question = questionService.findRandomByCategoryId(game.getRound().getCategory().getId());
            List<AnswerOption> answerOptions = answerOptionService.findAnswerOptionsByQuestionId(question.getId());
            char letter = 'a';
            StringBuilder answerOptionText = new StringBuilder();

            for (AnswerOption option : answerOptions) {
                answerOptionText.append(letter++).append(". ").append(option.getDescription()).append("\n");
            }
            String response = JOptionPane.showInputDialog(question.getDescription() + "\n" + answerOptionText);
            int position = Methods.validateResponse(response);

            if (position != 4) {
                game = playService.controlGame(answerOptions.get(position));
                Methods.showMessages(game);
            }
        }
    }
}
