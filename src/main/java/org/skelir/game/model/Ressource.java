package org.skelir.game.model;

import org.skelir.game.exception.NegativeQuantity;

/**
 * Ressources in game
 *
 * @author julien
 */
abstract class Ressource {
    private String name;

    private int quantity;

    public Ressource()
    {
        this("", 0);
    }

    public Ressource(
            String name,
            int quantity
    ){
        setName(name);
        setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Add quantity
     * @param quantity
     */
    public void addQuantity(int quantity) {
        setQuantity(this.quantity + quantity);
    }

    /**
     * Sub quantity
     * @param quantity
     * @throws NegativeQuantity Negative quantity is impossible
     */
    public void subQuantity(int quantity) throws NegativeQuantity {
        if (getQuantity() - quantity < 0)
            throw new NegativeQuantity();

        setQuantity(getQuantity() - quantity);
    }

    /**
     * Set quantity
     * @param quantity
     */
    private void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public boolean hasQuantity(
            int quantity
    ){
        return getQuantity() >= quantity;
    }
}
