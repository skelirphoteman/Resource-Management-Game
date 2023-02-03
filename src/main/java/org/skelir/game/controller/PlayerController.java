package org.skelir.game.controller;

import org.skelir.game.exception.InsufficientRessourcesException;
import org.skelir.game.model.PlayerLevel;
import org.skelir.game.model.Storage;
import org.skelir.game.vue.PlayerInformationView;
import org.skelir.game.vue.ViewInterface;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Singleton Design Pattern
 * @julien
 */
public class PlayerController {
    private static PlayerController INSTANCE = new PlayerController();

    private Storage storage;

    private PlayerLevel level;
    private PlayerController(){
        init();
    }

    private void init(){
        this.storage = new Storage();
        storage.addOr(50);

        PlayerLevel level1 = new PlayerLevel();
        level1.setCost(300, 20, 20);

        PlayerLevel level2 = new PlayerLevel();
        level1.setNextLevel(level2);

        this.level = level1;
    }

    /**
     * instance of PlayerController Singleton
     * @return
     */
    public static PlayerController getInstance(){
        return INSTANCE;
    }

    public void levelUp(ViewInterface viewInterface)
    {
        try {
            setPlayerLevel(
                    getLevel().levelUp(
                            getStorage()
                    )
            );
        } catch (InsufficientRessourcesException e) {
            viewInterface.errorResponse(e.getMessage());
        }
    }

    public PlayerLevel getLevel()
    {
        return this.level;
    }

    /**
     *
     * @return Player's storage
     */
    private Storage getStorage() {
        return this.storage;
    }

    /**
     *
     * @param playerLevel
     */
    private void setPlayerLevel(
            PlayerLevel playerLevel
    )
    {
        this.level = playerLevel;
    }

    public void informations(ViewInterface playerInformationView) {
        ArrayList<String> informations = new ArrayList<>();
        informations.add(new StringBuilder().append("Level : ").append(getLevel().getLevel()).toString());
        informations.add("Storage :");
        informations.add(new StringBuilder().append("\t- Or : ").append(getStorage().getOrQuantity()).toString());
        informations.add(new StringBuilder().append("\t- Wood : ").append(getStorage().getWoodQuantity()).toString());
        informations.add(new StringBuilder().append("\t- Iron : ").append(getStorage().getIronQuantity()).toString());

        playerInformationView.validResponse(informations);
    }
}
