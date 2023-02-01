package org.skelir.game.exception;

public class NegativeQuantity extends Exception {

    public NegativeQuantity()
    {
        super("You can't have a negative quantity");
    }
}
