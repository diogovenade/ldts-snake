package viewer.menu;

import gui.LanternaGUI;
import model.Position;
import model.menu.Settings;
import viewer.Viewer;

public class SettingsViewer extends Viewer<Settings> {
    public SettingsViewer(Settings settings) {
        super(settings);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        gui.drawText(new Position(5, 5), "SETTINGS", "#FFFFFF");
        gui.drawText(new Position(5, 7), getModel().getEntry(0), "#FFFFFF");
        for (int i = 0; i < getModel().getNumberSizeEntries(); i++) {
            gui.drawText(new Position (6, 8 + i),
                    getModel().getSizeEntry(i),
                    getModel().isSelectedSizeEntry(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position (5, 12), getModel().getEntry(1), "#FFFFFF");
        for (int i = 0; i < getModel().getNumberSpeedEntries(); i++) {
            gui.drawText(new Position(6, 13 + i),
                    getModel().getSpeedEntry(i),
                    getModel().isSelectedSpeedEntry(i) ? "#FFD700" : "#FFFFFF");
        }

        gui.drawText(new Position(5, 17), "BACK", getModel().isSelected(2) ? "#FFD700" : "#FFFFFF");
    }

}
