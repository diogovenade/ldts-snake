package l03gr05.states;

import l03gr05.controller.Controller;
import l03gr05.controller.game.ArenaController;
import l03gr05.controller.game.SnakeController;
import l03gr05.model.game.arena.Arena;
import l03gr05.viewer.Viewer;
import l03gr05.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }
    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel(), new SnakeController(getModel()));
    }
    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }
}
