package org.skelir.game.vue;

import org.skelir.game.exception.InvalidSelectableChoiceException;

public interface ViewInterface {

    public void errorResponse(String error);

    public void validResponse();

    public ViewInterface update(int choice) throws InvalidSelectableChoiceException;

    public void render();
}
