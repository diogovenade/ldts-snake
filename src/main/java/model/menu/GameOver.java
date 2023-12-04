package model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver extends MenuModel {

    public GameOver() {
        super();
        entries = Arrays.asList("RESTART GAME", "MAIN MENU");
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedMain() {
        return isSelected(1);
    }
}