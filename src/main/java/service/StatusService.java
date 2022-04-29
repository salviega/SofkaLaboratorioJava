package service;

import entity.Status;
import repository.StatusRepository;

public class StatusService {

    private final StatusRepository statusRepository = new StatusRepository();

    public Status findById(Integer id) {
        return statusRepository.findById(id);
    }
}
