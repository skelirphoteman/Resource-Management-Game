package org.skelir.game.registry;

/**
 * @author julien
 */
public class ItemRegistryIdentifier<T> {

    private int id;

    private ItemRegistry<T> item;

    public ItemRegistryIdentifier(
            int id,
            ItemRegistry<T> item
    ){
        setId(id);
        setItem(item);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemRegistry<T> getItem() {
        return item;
    }

    public void setItem(ItemRegistry<T> item) {
        this.item = item;
    }
}
