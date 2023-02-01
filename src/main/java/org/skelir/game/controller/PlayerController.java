package org.skelir.game.controller;

import org.skelir.game.model.Storage;

/**
 * Singleton Design Pattern
 * @julien
 */
public class PlayerController {
    private static PlayerController INSTANCE = new PlayerController();

    private Storage storage;

    private PlayerController(){
        init();
    }

    private void init(){
        this.storage = new Storage();
    }

    /**
     * instance of PlayerController Singleton
     * @return
     */
    public PlayerController getInstance(){
        return INSTANCE;
    }
}
