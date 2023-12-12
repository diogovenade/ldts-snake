package l03gr05.controller.menu;

import l03gr05.Game;
import l03gr05.controller.Controller;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.GameOver;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.GameState;
import l03gr05.states.MainMenuState;
import l03gr05.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException, URISyntaxException, FontFormatException {
        State state = game.getState();
        int speedIndex = state.getSpeedIndex();
        int sizeIndex = state.getSizeIndex();
        boolean obstacles = state.isObstacles();
        switch(action) {
            case Up:
                getModel().previousEntry();
                break;
            case Down:
                getModel().nextEntry();
                break;
            case Select:
                State newState;
                if (getModel().isSelectedRestart()) {
                    if (sizeIndex == 0) {
                        game.setWindowSize(15, 15);
                        newState = new GameState(new ClassicArenaBuilder(15, 15).createArena());
                    }
                    else if (sizeIndex == 1) {
                        newState = new GameState(new ClassicArenaBuilder(20, 20).createArena());
                    }
                    else {
                        game.setWindowSize(25, 22);
                        newState = new GameState(new ClassicArenaBuilder(25, 22).createArena());
                    }
                    newState.setSpeedIndex(speedIndex);
                    newState.setSizeIndex(sizeIndex);
                    newState.setObstacles(obstacles);
                    game.setState(newState);
                }
                if (getModel().isSelectedMain()) {
                    game.setState(new MainMenuState(new MainMenu()));
                }
        }
    }

}
