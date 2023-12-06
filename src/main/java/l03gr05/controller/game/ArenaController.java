package l03gr05.controller.game;

import l03gr05.Game;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.Arena;

public class ArenaController extends GameController {
    private final SnakeController snakeController;

    public ArenaController(Arena arena) {
        super(arena);
        this.snakeController = new SnakeController(arena);
    }

    @Override
    public void step(Game game, Action action, long time) {}
}
