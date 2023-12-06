package l03gr05.model.menu;

import java.util.Arrays;

public class GameOver extends MenuModel {
    private int sizeIndex;
    private int speedIndex;

    public GameOver(int sizeIndex, int speedIndex) {
        super();
        entries = Arrays.asList("RESTART GAME", "MAIN MENU");
        this.sizeIndex = sizeIndex;
        this.speedIndex = speedIndex;
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedMain() {
        return isSelected(1);
    }

    public int getSizeIndex() {
        return sizeIndex;
    }

    public int getSpeedIndex() {
        return speedIndex;
    }
}