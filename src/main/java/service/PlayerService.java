package service;

import entity.Player;
import repository.PlayerRepository;

public class PlayerService {

    private final PlayerRepository playerRepository = new PlayerRepository();

    public Player findById(Integer id) {
        return playerRepository.findById(id);
    }

    public void save(Player player) {
        playerRepository.save(player);
    }
}
