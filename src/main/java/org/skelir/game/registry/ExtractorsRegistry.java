package org.skelir.game.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * @author julien
 */
public class ExtractorsRegistry {

    public static final String TYPE_OR = "or";
    public static final String TYPE_WOOD = "wood";

    /**
     * Singleton Instance of ExtractorRegistry
     */
    private static ExtractorsRegistry instance = new ExtractorsRegistry();

    private List<ItemRegistry<ExtractorPrototype>> items;

    private ExtractorsRegistry()
    {
        init();
    }

    private void init(){
        items = new Vector<>();

        items.add(
                new ItemRegistry<>(
                        ExtractorsRegistry.TYPE_OR,
                        new ExtractorPrototype(
                                "Or extractor lvl 1",
                                15
                        )
                )
        );

        items.add(
                new ItemRegistry<>(
                        ExtractorsRegistry.TYPE_WOOD,
                        new ExtractorPrototype(
                                "Wood extractor lvl 1",
                                10
                        )
                )
        );
    }

    public static ExtractorsRegistry getInstance(

    ){
        return instance;
    }

    /**
     * Get extractorsProtoype regroup by Type
     * @return list
     */
    public HashMap<String, List<ItemRegistryIdentifier<ExtractorPrototype>>> getByType(){
        HashMap<String, List<ItemRegistryIdentifier<ExtractorPrototype>>> list = new HashMap<>();

        int index = 0;
        for (ItemRegistry<ExtractorPrototype> item:
             items) {
            if (!list.containsKey(item.getType())) {
                list.put(item.getType(), new Vector<>());
            }
            list.get(item.getType()).add(new ItemRegistryIdentifier<>(index++ , item));
        }

        return list;
    }
}
