package org.skelir.game.exception;

public class InsufficientRessourcesException extends Exception {

    public InsufficientRessourcesException()
    {
        super("You don't have sufficiency ressources required");
    }
}
