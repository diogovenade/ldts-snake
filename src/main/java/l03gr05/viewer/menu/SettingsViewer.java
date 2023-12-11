package l03gr05.viewer.menu;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.Position;
import l03gr05.model.menu.Settings;
import l03gr05.viewer.Viewer;

public class SettingsViewer extends Viewer<Settings> {
    public SettingsViewer(Settings settings) {
        super(settings);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        gui.drawText(new Position(1,1), "SIZE: " + getModel().getSize(), "#FFFFFF");
        gui.drawText(new Position(1,2), "SPEED: " + getModel().getSpeed(), "#FFFFFF");
        gui.drawText(new Position(1,3), "OBSTACLES: " + getModel().getObstacles(), "#FFFFFF");
        gui.drawText(new Position(5, 4), "SIZE", "#FFFFFF");
        for (int i = 0; i < 3; i++) {
            gui.drawText(new Position (6, 5 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position (5, 9), "SPEED", "#FFFFFF");
        for (int i = 3; i < 7; i++) {
            gui.drawText(new Position(6, 10 + i - 3),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position(5, 15), "OBSTACLES", "#FFFFFF");
        for (int i = 7; i < 9; i++) {
            gui.drawText(new Position(6, 16 + i - 7),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position (5, 18), getModel().getEntry(9), getModel().isSelected(9) ? "#FFD700" : "#FFFFFF");
    }

}
