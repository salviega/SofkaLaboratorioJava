package util;

import entity.Game;

import javax.swing.*;
import java.util.List;

public class Methods {

    public static Integer validateResponse(String response) {
        switch (response.toLowerCase()) {
            case "a":
                return  0;
            case "b":
                return  1;
            case "c":
                return  2;
            case "d":
                return  3;
            default:
                return 4;
        }
    }

    public static void showMessages(Game game) {
        switch (game.getStatus().getDescription()) {
            case "Terminado":
                JOptionPane.showMessageDialog(null, "Gracias por jugar, su puntaje es: "
                        + game.getAccumulated());
                break;
            case "Ganado":
                JOptionPane.showMessageDialog(null, "Felicidades ganaste");
                break;
            case "Perdido":
                JOptionPane.showMessageDialog(null, "Lo siento, perdiste!");
                break;
            default:
                break;
        }
    }

    public static void showGameHistory(List<Game> games) {
        games.forEach(g -> System.out.printf("ID: %s, Jugador: %s Acumulado: %s, Ronda: %s, Estado: %s%n",
                g.getId(),
                g.getPlayer().getId() + " - " +g.getPlayer().getName(),
                g.getAccumulated(),
                g.getRound().getDescription(),
                g.getStatus().getDescription()));
    }
}
