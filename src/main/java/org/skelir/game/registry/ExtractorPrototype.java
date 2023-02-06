package org.skelir.game.registry;

/**
 * @author julien
 */
public class ExtractorPrototype {

    private String name;

    private int efficiency;


    ExtractorPrototype(
            String name,
            int efficiency
    ){
        setName(name);
        setEfficiency(efficiency);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
