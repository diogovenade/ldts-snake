package l03gr05.controller.game;

import l03gr05.controller.Controller;
import l03gr05.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
