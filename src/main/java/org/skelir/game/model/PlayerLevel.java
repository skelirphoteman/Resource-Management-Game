package org.skelir.game.model;

import org.skelir.game.exception.InsufficientRessourcesException;

/**
 * @julien
 */
public class PlayerLevel {

    private int level;

    private PlayerLevel nextLevel;

    private int orCost;

    private int woodCost;

    private int ironCost;

    public PlayerLevel(){
        this(0);
    }

    public PlayerLevel(
            int level
    ){
        setLevel(level);
    }

    public PlayerLevel(
            int level,
            PlayerLevel nextLevel
    ){
        this(level);
        setNextLevel(nextLevel);
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public PlayerLevel getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(PlayerLevel nextLevel) {
        this.nextLevel = nextLevel;
    }

    /**
     * Set the cost to go to nextLevel
     * @param or
     * @param wood
     * @param iron
     */
    public void setCost(
            int or,
            int wood,
            int iron
    ){
        this.orCost     = or;
        this.woodCost   = wood;
        this.ironCost   = iron;
    }

    /**
     * Get the nextLevel
     * @param storage
     * @return
     * @throws InsufficientRessourcesException
     */
    public PlayerLevel levelUp(
            Storage storage
    ) throws InsufficientRessourcesException {
        if (!storage.hasRessource(orCost, woodCost, ironCost))
            throw new InsufficientRessourcesException();

        storage.subRessources(orCost, woodCost, ironCost);

        return nextLevel;
    }

    @Override
    public String toString() {
        return String.valueOf(getLevel());
    }
}
