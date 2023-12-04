package model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends MenuModel {
    public MainMenu() {
        super();
        entries = Arrays.asList("START", "SETTINGS", "QUIT");
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedSettings() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}
