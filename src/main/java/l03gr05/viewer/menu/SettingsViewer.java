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
        gui.drawText(new Position(5, 5), "SETTINGS", "#FFFFFF");
        gui.drawText(new Position(5, 7), "SIZE", "#FFFFFF");
        for (int i = 0; i < 3; i++) {
            gui.drawText(new Position (6, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position (5, 12), "SPEED", "#FFFFFF");
        for (int i = 3; i < 6; i++) {
            gui.drawText(new Position(6, 13 + i - 3),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position(5, 19), getModel().getEntry(6), getModel().isSelected(6) ? "#FFD700" : "#FFFFFF");
    }

}
