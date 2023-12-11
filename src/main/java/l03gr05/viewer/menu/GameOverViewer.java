package l03gr05.viewer.menu;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.Position;
import l03gr05.model.menu.GameOver;
import l03gr05.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        gui.drawText(new Position(5, 5), "GAME OVER", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
