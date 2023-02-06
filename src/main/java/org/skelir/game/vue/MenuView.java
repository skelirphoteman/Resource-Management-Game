package org.skelir.game.vue;

public class MenuView extends View{
    public MenuView()
    {
        super();
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
        getSelectableChoices().add(new SelectableChoice("Level Up", new LevelUpView()));
        getSelectableChoices().add(new SelectableChoice("Buy Extractor", new BuyExtractorView()));
    }
}
