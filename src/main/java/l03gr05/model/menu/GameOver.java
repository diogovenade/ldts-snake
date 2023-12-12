package l03gr05.model.menu;

import java.util.Arrays;

public class GameOver extends MenuModel {
    public GameOver(int score) {
        super();
        this.score = score;
        entries = Arrays.asList("RESTART GAME", "MAIN MENU");
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedMain() {
        return isSelected(1);
    }

    @Override
    public int getScore() {
        return this.score;
    }
}