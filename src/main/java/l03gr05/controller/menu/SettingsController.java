package l03gr05.controller.menu;

import l03gr05.Game;
import l03gr05.controller.Controller;
import l03gr05.gui.Action;
import l03gr05.model.menu.MainMenu;
import l03gr05.model.menu.Settings;
import l03gr05.states.MainMenuState;
import l03gr05.states.SettingsState;
import l03gr05.states.State;

import java.io.IOException;

public class SettingsController extends Controller<Settings> {
    public SettingsController(Settings settings) {
        super(settings);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException {
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
                if (getModel().isSelectedBack()) {
                    State newState = new MainMenuState(new MainMenu());
                    newState.setSpeedIndex(speedIndex);
                    newState.setSizeIndex(sizeIndex);
                    newState.setObstacles(obstacles);
                    game.setState(newState);
                }

                if (getModel().isSelectedSmall()) {
                    state.setSizeIndex(0);
                    getModel().setSize("SMALL");
                }

                if (getModel().isSelectedMedium()) {
                    state.setSizeIndex(1);
                    getModel().setSize("MEDIUM");
                }

                if (getModel().isSelectedLarge()) {
                    state.setSizeIndex(2);
                    getModel().setSize("LARGE");
                }

                if (getModel().isSelectedSlow()) {
                    state.setSpeedIndex(0);
                    getModel().setSpeed("SLOW");
                }

                if (getModel().isSelectedMediumSpeed()) {
                    state.setSpeedIndex(1);
                    getModel().setSpeed("MEDIUM");
                }

                if (getModel().isSelectedFast()) {
                    state.setSpeedIndex(2);
                    getModel().setSpeed("FAST");
                }

                if (getModel().isSelectedYes()) {
                    state.setObstacles(true);
                    getModel().setObstacles("YES");
                }

                if (getModel().isSelectedNo()) {
                    state.setObstacles(false);
                    getModel().setObstacles("NO");
                }
        }
    }
}
