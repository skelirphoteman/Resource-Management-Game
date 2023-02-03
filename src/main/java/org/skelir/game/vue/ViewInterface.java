package org.skelir.game.vue;

import org.skelir.game.exception.InvalidSelectableChoiceException;

import java.util.ArrayList;
import java.util.List;

public interface ViewInterface {

    public void errorResponse(String error);

    public void validResponse(List<String> informations);

    public ViewInterface update(int choice) throws InvalidSelectableChoiceException;

    public void render();
}
