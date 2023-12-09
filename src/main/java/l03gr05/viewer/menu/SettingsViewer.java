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
        gui.drawText(new Position(5, 5), "SIZE", "#FFFFFF");
        for (int i = 0; i < 3; i++) {
            gui.drawText(new Position (6, 6 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position (5, 10), "SPEED", "#FFFFFF");
        for (int i = 3; i < 6; i++) {
            gui.drawText(new Position(6, 11 + i - 3),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position(5, 15), "OBSTACLES", "#FFFFFF");
        for (int i = 6; i < 8; i++) {
            gui.drawText(new Position(6, 16 + i - 6),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position (5, 19), getModel().getEntry(8), getModel().isSelected(8) ? "#FFD700" : "#FFFFFF");
    }

}
