package l03gr05.controller.menu;

import l03gr05.Game;
import l03gr05.controller.Controller;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.MainMenu;
import l03gr05.model.menu.Settings;
import l03gr05.states.GameState;
import l03gr05.states.SettingsState;
import l03gr05.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException, URISyntaxException, FontFormatException {
        State<?> state = game.getState();
        int speedIndex = state.getSpeedIndex();
        int sizeIndex = state.getSizeIndex();
        boolean obstacles = state.isObstacles();
        String size = " ", speed = " ", obstaclesStr;
        speed = switch (speedIndex) {
            case 0 -> "SLOW";
            case 1 -> "MEDIUM";
            case 2 -> "FAST";
            case 3 -> "TEST";
            default -> speed;
        };
        size = switch (sizeIndex) {
            case 0 -> "SMALL";
            case 1 -> "MEDIUM";
            case 2 -> "LARGE";
            default -> size;
        };

        if (obstacles) obstaclesStr = "YES";
        else obstaclesStr = "NO";



        switch(action) {
            case Up:
                getModel().previousEntry();
                break;
            case Down:
                getModel().nextEntry();
                break;
            case Select:
                State<?> gameState;
                if (getModel().isSelectedStart()) {if (sizeIndex == 0) {
                    game.setWindowSize(15, 15);
                    gameState = new GameState(new ClassicArenaBuilder(15, 15).createArena());
                }
                else if (sizeIndex == 1) {
                    gameState = new GameState(new ClassicArenaBuilder(20, 20).createArena());
                }
                else {
                    game.setWindowSize(25, 22);
                    gameState = new GameState(new ClassicArenaBuilder(25, 22).createArena());
                }
                gameState.setSizeIndex(sizeIndex);
                gameState.setSpeedIndex(speedIndex);
                gameState.setObstacles(obstacles);
                game.setState(gameState);
                }
                if (getModel().isSelectedExit()) {
                    game.setState(null);
                }

                if (getModel().isSelectedSettings()) {
                    SettingsState newState = new SettingsState(new Settings());
                    newState.setSizeIndex(sizeIndex);
                    newState.setSpeedIndex(speedIndex);
                    newState.setObstacles(obstacles);

                    newState.getModel().setSize(size);
                    newState.getModel().setSpeed(speed);
                    newState.getModel().setObstacles(obstaclesStr);

                    game.setState(newState);
                }

        }

    }
}
