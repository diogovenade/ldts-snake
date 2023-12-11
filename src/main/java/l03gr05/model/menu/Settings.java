package l03gr05.model.menu;

import java.util.Arrays;
import java.util.List;

public class Settings extends MenuModel {
    private String size;
    private String speed;
    private String obstacles;

    public Settings() {
        super();
        entries = Arrays.asList("SMALL", "MEDIUM", "LARGE", "SLOW", "MEDIUM", "FAST", "TEST", "YES", "NO", "BACK");
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
    public boolean isSelectedYes() {
        return isSelected(7);
    }

    public boolean isSelectedNo() {
        return isSelected(8);
    }

    public boolean isSelectedBack() {
        return isSelected(9);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getObstacles() {
        return obstacles;
    }

    public void setObstacles(String obstacles) {
        this.obstacles = obstacles;
    }

    public boolean isSelectedTest() {return isSelected(6);}
}
