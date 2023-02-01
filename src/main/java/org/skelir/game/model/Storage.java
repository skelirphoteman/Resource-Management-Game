package org.skelir.game.model;


import org.skelir.game.exception.NegativeQuantity;

/**
 * Player's ressources storage
 */
public class Storage {
    private Or or;

    private Wood wood;

    private Iron iron;

    public Storage()
    {
        setOr(new Or());
        setWood(new Wood());
        setIron(new Iron());
    }

    private void setOr(Or or) {
        this.or = or;
    }

    private void setWood(Wood wood) {
        this.wood = wood;
    }


    private void setIron(Iron iron) {
        this.iron = iron;
    }

    /**
     * add Or to storage
     * @param or
     */
    public void addOr(Or or) {
        or.addQuantity(or.getQuantity());
    }

    /**
     * add Wood to storage
     * @param wood
     */
    public void addWood(Wood wood) {
        wood.addQuantity(wood.getQuantity());
    }

    /**
     * add Iron to storage
     * @param iron
     */
    public void addIron(Iron iron) {
        iron.addQuantity(iron.getQuantity());
    }


    /**
     * Return if Storage has quantity required
     * @param or
     * @param wood
     * @param iron
     * @return
     */
    public boolean hasRessource(
            int or,
            int wood,
            int iron
    ) {
        return this.or.hasQuantity(or) &&
                this.wood.hasQuantity(wood) &&
                this.iron.hasQuantity(iron);
    }

    public void subRessources(
            int orCost, int woodCost, int ironCost
    ) {
        try {
            this.or.subQuantity(orCost);
            this.wood.subQuantity(woodCost);
            this.iron.subQuantity(ironCost);
        }catch (NegativeQuantity e) {
            e.printStackTrace();
        }

    }
}
