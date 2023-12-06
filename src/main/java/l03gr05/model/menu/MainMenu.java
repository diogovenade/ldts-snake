package l03gr05.model.menu;

import java.util.Arrays;

public class MainMenu extends MenuModel {
    private int sizeIndex;
    private int speedIndex;
    public MainMenu(int sizeIndex, int speedIndex) {
        super();
        entries = Arrays.asList("START", "SETTINGS", "QUIT");
        this.sizeIndex = sizeIndex;
        this.speedIndex = speedIndex;
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

    public int getSizeIndex() {
        return sizeIndex;
    }

    public int getSpeedIndex() {
        return speedIndex;
    }
}
