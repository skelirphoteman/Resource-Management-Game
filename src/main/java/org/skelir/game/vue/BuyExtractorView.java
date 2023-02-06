package org.skelir.game.vue;

import org.skelir.game.exception.InvalidSelectableChoiceException;
import org.skelir.game.registry.ExtractorPrototype;
import org.skelir.game.registry.ExtractorsRegistry;
import org.skelir.game.registry.ItemRegistryIdentifier;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class BuyExtractorView extends View{
    private HashMap<Integer, Integer> buyableExtractors;

    public BuyExtractorView()
    {
        super();
        buyableExtractors = new HashMap<>();
    }

    @Override
    public ViewInterface update(int choice) throws InvalidSelectableChoiceException {

        try {
            return super.update(choice);
        }catch (InvalidSelectableChoiceException e){
            if (
                    choice >= (getSelectableChoices().size() + buyableExtractors.size())
            )
                throw new InvalidSelectableChoiceException();
            getPlayerController().buyExtractor(
                    buyableExtractors.get(choice),
                    this);
            return new MenuView();
        }
    }


    @Override
    public void render() {
        super.render();
        getPlayerController().informations(this);

        StringBuilder message = new StringBuilder();

        message.append(super.getPrintChoice());

        message.append("Buyable extractors : \n");

        int choiceIndex = getSelectableChoices().size();

        HashMap<String, List<ItemRegistryIdentifier<ExtractorPrototype>>> list = ExtractorsRegistry.getInstance().getByType();

        Set<String> types = list.keySet();

        for (String type :
                types){
            List<ItemRegistryIdentifier<ExtractorPrototype>> extractorPrototypeList = list.get(type);

            message.append("Extractor type : ")
                    .append(type)
                    .append("\n");

            for (ItemRegistryIdentifier<ExtractorPrototype> identifier:
                 extractorPrototypeList) {
                message.append("(")
                        .append(choiceIndex)
                        .append(")")
                        .append("\t- ")
                        .append(identifier.getItem().getItem().getName())
                        .append("\n");

                buyableExtractors.put(choiceIndex++, identifier.getId());
            }
        }

        System.out.println(message);
    }

    protected void generateSelectableChoices() {
        getSelectableChoices().add(new SelectableChoice("Come back to menu", new MenuView()));
    }
}
