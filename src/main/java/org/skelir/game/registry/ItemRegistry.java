package org.skelir.game.registry;

import java.rmi.registry.Registry;

public class ItemRegistry<T> {

    private String type;

    public T item;

    public ItemRegistry(
        T item
    ){
        this("default", item);
    }

    public ItemRegistry(
            String type,
            T item
    ){
        setType(type);
        setItem(item);
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public T getItem() {
        return item;
    }

    private void setItem(T item) {
        this.item = item;
    }
}
