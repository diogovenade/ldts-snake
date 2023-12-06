package l03gr05.controller.menu;

import l03gr05.Game;
import l03gr05.controller.Controller;
import l03gr05.gui.Action;
import l03gr05.model.menu.MainMenu;
import l03gr05.model.menu.Settings;
import l03gr05.states.MainMenuState;
import l03gr05.states.SettingsState;

import java.io.IOException;

public class SettingsController extends Controller<Settings> {
    public SettingsController(Settings settings) {
        super(settings);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException {
        switch(action) {
            case Up:
                getModel().previousEntry();
                break;
            case Down:
                getModel().nextEntry();
                break;
            case Select:
                if (getModel().isSelectedBack()) {
                    game.setState(new MainMenuState(new MainMenu(getModel().getSizeIndex(), getModel().getSpeedIndex())));
                }
                if (getModel().isSelectedSize()) {
                    switch(action) {
                        case Up:
                            getModel().previousSizeOption();
                            break;
                        case Down:
                            getModel().nextSizeOption();
                            break;
                        case Select:
                            if (getModel().isSelectedSizeEntry(0))
                                game.setState(new SettingsState(new Settings(0, getModel().getSpeedIndex())));
                            if (getModel().isSelectedSizeEntry(1))
                                game.setState(new SettingsState(new Settings(1, getModel().getSpeedIndex())));
                            if (getModel().isSelectedSizeEntry(2))
                                game.setState(new SettingsState(new Settings(2, getModel().getSpeedIndex())));
                    }
                }
                if (getModel().isSelectedSpeed()) {
                    switch(action) {
                        case Up:
                            getModel().previousSpeedOption();
                            break;
                        case Down:
                            getModel().nextSpeedOption();
                            break;
                        case Select:
                            if (getModel().isSelectedSpeedEntry(0))
                                game.setState(new SettingsState(new Settings(getModel().getSizeIndex(), 0)));
                            if (getModel().isSelectedSpeedEntry(1))
                                game.setState(new SettingsState(new Settings(getModel().getSizeIndex(), 1)));
                            if (getModel().isSelectedSpeedEntry(2))
                                game.setState(new SettingsState(new Settings(getModel().getSizeIndex(), 2)));
                    }
                }

        }
    }
}
