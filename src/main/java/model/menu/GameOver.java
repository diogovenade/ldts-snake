package model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver implements MenuModel {
    private static final List<String> ENTRIES = Arrays.asList("RESTART GAME", "MAIN MENU");
    private int selectedEntry = 0;
    private boolean running;

    public GameOver() {
        this.running = true;
    }

    public void nextEntry() {
        selectedEntry++;
        if (selectedEntry > ENTRIES.size() - 1)
            selectedEntry = 0;
    }

    public void previousEntry() {
        selectedEntry--;
        if (selectedEntry < 0)
            selectedEntry = ENTRIES.size() - 1;
    }

    public String getEntry(int i) {
        return ENTRIES.get(i);
    }

    public boolean isSelected(int i) {
        return selectedEntry == i;
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedMain() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return ENTRIES.size();
    }

    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
