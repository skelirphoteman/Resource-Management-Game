package org.skelir.game.vue;

import org.skelir.game.exception.InvalidSelectableChoiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView extends View{
    public MenuView()
    {
        super();
    }

    @Override
    public void errorResponse(String error) {

    }

    @Override
    public void render() {
        super.render();
        StringBuilder message = new StringBuilder();

        message.append(super.getPrintChoice());

        System.out.println(message);

    }

    protected void generateSelectableChoices() {
        getSelectableChoices().add(new SelectableChoice("View player information", new PlayerInformationView()));
    }
}
