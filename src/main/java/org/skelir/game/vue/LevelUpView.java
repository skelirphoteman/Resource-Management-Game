package org.skelir.game.vue;

import java.util.List;

public class LevelUpView extends View{
    public LevelUpView()
    {
        super();
    }

    @Override
    public void validResponse(List<String> informations)
    {
        StringBuilder message = new StringBuilder();

        message.append("------Player informations------ \n");
        for (String information:
                informations) {
            message.append(information + "\n");
        }
        message.append("---------- End ---------- \n");
        System.out.println(message);
    }

    @Override
    public void render() {
        super.render();
        getPlayerController().levelUp(this);

        StringBuilder message = new StringBuilder();

        message.append(super.getPrintChoice());

        System.out.println(message);
    }

    protected void generateSelectableChoices() {
        getSelectableChoices().add(new SelectableChoice("Come back to menu", new MenuView()));
    }
}
