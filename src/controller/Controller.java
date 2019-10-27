package controller;

import Repository.IStateRepository;

public class Controller {

    private IStateRepository stateRepository;

    Controller(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


}
