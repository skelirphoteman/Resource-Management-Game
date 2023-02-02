package org.skelir.game.vue;

/**
 * @author julien
 */
public class SelectableChoice {

    private String message;

    private ViewInterface viewInterface;

    public SelectableChoice(
            String message,
            ViewInterface view
    )
    {
        setMessage(message);
        setViewInterface(view);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ViewInterface getViewInterface() {
        return viewInterface;
    }

    public void setViewInterface(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }
}
