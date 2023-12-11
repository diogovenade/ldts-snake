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
        State state = game.getState();
        int speedIndex = state.getSpeedIndex();
        int sizeIndex = state.getSizeIndex();
        boolean obstacles = state.isObstacles();
        String size = " ", speed = " ", obstaclesStr = " ";
        switch (speedIndex) {
            case 0:
                speed = "SLOW";
                break;
            case 1:
                speed = "MEDIUM";
                break;
            case 2:
                speed = "FAST";
                break;
        }
        switch (sizeIndex) {
            case 0:
                size = "SMALL";
                break;
            case 1:
                size = "MEDIUM";
                break;
            case 2:
                size = "LARGE";
                break;
        }

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
                State gameState;
                if (getModel().isSelectedStart()) {if (sizeIndex == 0) {
                    game.setWindowSize(15, 15);
                    gameState = new GameState(new ClassicArenaBuilder(15, 15).createArena());
                }
                else if (sizeIndex == 1) {
                    game.setWindowSize(20, 20);
                    gameState = new GameState(new ClassicArenaBuilder(20, 20).createArena());
                }
                else {
                    game.setWindowSize(25, 25);
                    gameState = new GameState(new ClassicArenaBuilder(25, 25).createArena());
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
                    State newState = new SettingsState(new Settings());
                    newState.setSizeIndex(sizeIndex);
                    newState.setSpeedIndex(speedIndex);
                    newState.setObstacles(obstacles);

                    ((SettingsState) newState).getModel().setSize(size);
                    ((SettingsState) newState).getModel().setSpeed(speed);
                    ((SettingsState) newState).getModel().setObstacles(obstaclesStr);

                    game.setState(newState);
                }

        }

    }
}
