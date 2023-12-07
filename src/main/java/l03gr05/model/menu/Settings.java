package l03gr05.model.menu;

import java.util.Arrays;
import java.util.List;

public class Settings extends MenuModel {

    public Settings() {
        super();
        entries = Arrays.asList("SMALL", "MEDIUM", "LARGE", "SLOW", "MEDIUM", "FAST", "BACK");
    }

    public boolean isSelectedSmall() {
        return isSelected(0);
    }

    public boolean isSelectedMedium() {
        return isSelected(1);
    }

    public boolean isSelectedLarge() {
        return isSelected(2);
    }

    public boolean isSelectedSlow() {
        return isSelected(3);
    }

    public boolean isSelectedMediumSpeed() {
        return isSelected(4);
    }

    public boolean isSelectedFast() {
        return isSelected(5);
    }

    public boolean isSelectedBack() {
        return isSelected(6);
    }

}
