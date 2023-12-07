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

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException {
        State state = game.getState();
        int speedIndex = state.getSpeedIndex();
        int sizeIndex = state.getSizeIndex();
        switch(action) {
            case Up:
                getModel().previousEntry();
                break;
            case Down:
                getModel().nextEntry();
                break;
            case Select:
                if (getModel().isSelectedStart()) {
                    game.setState(new GameState(new ClassicArenaBuilder(20, 20).createArena()));
                }
                if (getModel().isSelectedExit()) {
                    game.setState(null);
                }

                if (getModel().isSelectedSettings()) {
                    game.setState(new SettingsState(new Settings()));
                }

        }

    }
}
