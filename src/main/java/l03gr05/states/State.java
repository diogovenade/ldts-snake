package l03gr05.states;

import l03gr05.Game;
import l03gr05.controller.Controller;
import l03gr05.gui.Action;
import l03gr05.gui.LanternaGUI;
import l03gr05.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Controller<T> getController();
    protected abstract Viewer<T> getViewer();

    public T getModel() {
        return model;
    }

    public void step(Game game, LanternaGUI gui, long time) throws IOException {
        Action action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
