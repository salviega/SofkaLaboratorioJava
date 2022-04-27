package service;

import entity.Round;
import repository.RoundRepository;

public class RoundService {

    private final RoundRepository roundRepository = new RoundRepository();

    public Round findById(Integer id) {
        return roundRepository.findById(id);
    }
}
