package model.menu;

import java.util.Arrays;
import java.util.List;

public class Settings implements MenuModel {
    private static final List<String> ENTRIES = Arrays.asList("SIZE", "SPEED", "BACK");
    private static final List<String> SIZE_OPTIONS = Arrays.asList("SMALL", "MEDIUM", "LARGE");
    private static final List<String> SPEED_OPTIONS = Arrays.asList("SLOW", "MEDIUM", "FAST");

    private int selectedEntry = 0;
    private boolean running;
    private int sizeIndex = 1;
    private int speedIndex = 1;

    public Settings() {
        this.running = true;
    }

    public void nextSizeOption() {
        sizeIndex++;
        if (sizeIndex > SIZE_OPTIONS.size() - 1)
            sizeIndex = 0;
    }

    public void previousSizeOption() {
        sizeIndex--;
        if (sizeIndex < 0)
            sizeIndex = SIZE_OPTIONS.size() - 1;
    }

    public void nextSpeedOption() {
        speedIndex++;
        if (speedIndex > SPEED_OPTIONS.size() - 1)
            speedIndex = 0;
    }

    public void previousSpeedOption() {
        speedIndex--;
        if (speedIndex < 0)
            speedIndex = SPEED_OPTIONS.size() - 1;
    }

    public String getSize() {
        return SIZE_OPTIONS.get(sizeIndex);
    }

    public String getSpeed() {
        return SPEED_OPTIONS.get(speedIndex);
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

    public boolean isSelected(int i) {
        return selectedEntry == i;
    }

    public boolean isSelectedSize() {
        return isSelected(0);
    }

    public boolean isSelectedSpeed() {
        return isSelected(1);
    }

    public boolean isSelectedBack() {
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
