package l03gr05.states;

import l03gr05.controller.Controller;
import l03gr05.controller.menu.SettingsController;
import l03gr05.model.menu.Settings;
import l03gr05.viewer.Viewer;
import l03gr05.viewer.menu.SettingsViewer;

public class SettingsState extends State<Settings> {
    public SettingsState(Settings settings) {
        super(settings);
    }

    @Override
    protected Viewer<Settings> getViewer() {
        return new SettingsViewer(getModel());
    }

    @Override
    protected Controller<Settings> getController() {
        return new SettingsController(getModel());
    }
}
