package viewer.menu;

import gui.LanternaGUI;
import model.Position;
import model.menu.MainMenu;
import viewer.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        gui.drawText(new Position(5, 5), "SNAKE", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
