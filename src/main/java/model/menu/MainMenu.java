package model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu implements MenuModel {
    private static final List<String> ENTRIES = Arrays.asList("START", "SETTINGS", "QUIT");
    private int selectedEntry = 0;
    private boolean running;

    public MainMenu() {
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

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedSettings() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
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
