package l03gr05.controller.game;

import l03gr05.Game;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.menu.GameOver;
import l03gr05.states.GameOverState;
import l03gr05.states.GameState;
import l03gr05.states.State;

public class ArenaController extends GameController {
    private final SnakeController snakeController;

    public ArenaController(Arena arena) {
        super(arena);
        this.snakeController = new SnakeController(arena);
    }

    @Override
    public void step(Game game, Action action, long time) {
        if (action == Action.Quit || snakeController.isGameOver()) {
            State gameState = game.getState();
            int sizeIndex = ((GameState) gameState).getsizeIndex();
            int speedIndex = ((GameState) gameState).getSpeedIndex();
            game.setState(new GameOverState(new GameOver(sizeIndex, speedIndex)));
        }
        else {
            snakeController.step(game, action, time);
        }
    }
}
