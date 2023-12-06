package l03gr05.controller;

import l03gr05.Game;
import l03gr05.gui.Action;
import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, Action action, long time) throws IOException;
}
