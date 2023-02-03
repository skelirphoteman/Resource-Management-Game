package org.skelir.game.vue;

import org.skelir.game.controller.PlayerController;
import org.skelir.game.exception.InvalidSelectableChoiceException;

import java.util.ArrayList;
import java.util.List;

abstract class View implements ViewInterface{

    PlayerController playerController;

    /**
     * List of selectable choice
     */
    private List<SelectableChoice> selectableChoices;

    protected View(){
        this.playerController = PlayerController.getInstance();
    }


    @Override
    public void errorResponse(String error) {
        System.out.println(error);
    }

    /**
     * Update next View from player choice
     * @param choice
     * @return
     * @throws InvalidSelectableChoiceException
     */
    @Override
    public ViewInterface update(int choice) throws InvalidSelectableChoiceException {
        if (choice >= getSelectableChoices().size())
            throw new InvalidSelectableChoiceException();
        return getSelectableChoices().get(choice).getViewInterface();
    }

    @Override
    public void render() {
        generateSelectableChoices();
    }


    protected List<SelectableChoice> getSelectableChoices() {
        if(selectableChoices == null){
            selectableChoices = new ArrayList<>();
        }
        return selectableChoices;
    }

    abstract void generateSelectableChoices();

    /**
     * @return the selectableChoice user can use
     */
    protected String getPrintChoice()
    {
        StringBuilder message = new StringBuilder();
        message.append("Select action : \n");

        int index = 0;
        for (SelectableChoice selectableChoice:
                getSelectableChoices()) {
            message.append("(" + (index++) + ") - " + selectableChoice.getMessage());
        }

        return message.toString();
    }

    /**
     * print valid Response
     * @param informations
     */
    public void validResponse(List<String> informations)
    {

    }

    public PlayerController getPlayerController()
    {
        return playerController;
    }
}
