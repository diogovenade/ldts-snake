package l03gr05.states;

import l03gr05.controller.Controller;
import l03gr05.controller.menu.GameOverController;
import l03gr05.model.menu.GameOver;
import l03gr05.viewer.Viewer;
import l03gr05.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
