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
        switch(action) {
            case Up:
                getModel().previousEntry();
                break;
            case Down:
                getModel().nextEntry();
                break;
            case Select:
                if (getModel().isSelectedBack()) {
                    game.setState(new MainMenuState(new MainMenu()));
                }

                if (getModel().isSelectedSmall()) {
                    state.setSizeIndex(0);
                }

                if (getModel().isSelectedMedium()) {
                    state.setSizeIndex(1);
                }

                if (getModel().isSelectedLarge()) {
                    state.setSizeIndex(2);
                }

                if (getModel().isSelectedSlow()) {
                    state.setSpeedIndex(0);
                }

                if (getModel().isSelectedMediumSpeed()) {
                    state.setSpeedIndex(1);
                }

                if (getModel().isSelectedFast()) {
                    state.setSpeedIndex(2);
                }



        }
    }
}
