package l03gr05.model.menu;

import java.util.Arrays;
import java.util.List;

public class Settings extends MenuModel {
    private static final List<String> SIZE_OPTIONS = Arrays.asList("SMALL", "MEDIUM", "LARGE");
    private static final List<String> SPEED_OPTIONS = Arrays.asList("SLOW", "MEDIUM", "FAST");
    private int sizeIndex;
    private int speedIndex;

    public Settings(int sizeIndex, int speedIndex) {
        super();
        entries = Arrays.asList("SIZE", "SPEED", "BACK");
        this.sizeIndex = sizeIndex;
        this.speedIndex = speedIndex;
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

    public int getNumberSizeEntries() {
        return SIZE_OPTIONS.size();
    }

    public int getNumberSpeedEntries() {
        return SPEED_OPTIONS.size();
    }

    public String getSizeEntry(int i) {
        return SIZE_OPTIONS.get(i);
    }

    public String getSpeedEntry(int i) {
        return SPEED_OPTIONS.get(i);
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
    public boolean isSelectedSizeEntry(int i) {
        return sizeIndex == i;
    }
    public boolean isSelectedSpeedEntry(int i) {
        return speedIndex == i;
    }

    public int getSizeIndex() {
        return sizeIndex;
    }

    public int getSpeedIndex() {
        return speedIndex;
    }
}
