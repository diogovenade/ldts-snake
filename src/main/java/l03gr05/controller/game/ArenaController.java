package l03gr05.controller.game;

import l03gr05.Game;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.menu.GameOver;
import l03gr05.states.GameOverState;
import l03gr05.states.GameState;
import l03gr05.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ArenaController extends GameController {
    private final SnakeController snakeController;

    public ArenaController(Arena arena) {
        super(arena);
        this.snakeController = new SnakeController(arena);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException, URISyntaxException, FontFormatException {
        State state = game.getState();
        int speedIndex = state.getSpeedIndex();
        int sizeIndex = state.getSizeIndex();
        boolean obstacles = state.isObstacles();
        if (action == Action.Quit || snakeController.isGameOver()) {
            State newState = new GameOverState(new GameOver());
            newState.setSizeIndex(sizeIndex);
            newState.setSpeedIndex(speedIndex);
            newState.setObstacles(obstacles);
            if (sizeIndex == 0 || sizeIndex == 2)
                game.setWindowSize(20, 20);
            game.setState(newState);
        }
        else {
            snakeController.step(game, action, time);
        }
    }
}
