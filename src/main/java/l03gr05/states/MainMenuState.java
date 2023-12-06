package l03gr05.states;

import l03gr05.controller.Controller;
import l03gr05.controller.menu.MainMenuController;
import l03gr05.model.menu.MainMenu;
import l03gr05.viewer.Viewer;
import l03gr05.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }
    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
