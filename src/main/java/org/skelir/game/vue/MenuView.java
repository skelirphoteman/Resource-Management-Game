package org.skelir.game.vue;

import org.skelir.game.exception.InvalidSelectableChoiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView implements ViewInterface{

    private List<SelectableChoice> selectableChoices;

    public MenuView()
    {
    }

    @Override
    public void errorResponse(String error) {

    }

    @Override
    public void validResponse() {

    }

    @Override
    public ViewInterface update(int choice) throws InvalidSelectableChoiceException {
        if (choice >= getSelectableChoices().size())
            throw new InvalidSelectableChoiceException();
        return getSelectableChoices().get(choice).getViewInterface();
    }

    @Override
    public void render() {
        generateSelectableChoices();
        StringBuilder message = new StringBuilder();
        message.append("Select action : \n");

        int index = 0;
        for (SelectableChoice selectableChoice:
             getSelectableChoices()) {
            message.append("(" + (index++) + ") - " + selectableChoice.getMessage());
        }
        System.out.println(message);

    }

    private List<SelectableChoice> getSelectableChoices() {
        return selectableChoices;
    }

    private void generateSelectableChoices() {
        selectableChoices = new ArrayList<>();
        selectableChoices.add(new SelectableChoice("View player information", new MenuView()));
    }
}
