package l03gr05.viewer.menu;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.Position;
import l03gr05.model.game.elements.Snake;
import l03gr05.model.menu.GameOver;
import l03gr05.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        gui.drawText(new Position(5, 3), "GAME OVER", "#FF0000");
        gui.drawText(new Position(5, 6), "SCORE : " + getModel().getScore(), "#00FF00");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 10 + i * 2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

        Snake snake = new Snake(11, 17);
        int i = 4;
        while (i != 0) {
            snake.addPosition();
            i--;
        }
        gui.drawSnake(snake);

        gui.drawWall(new Position(12, 17));
        gui.drawWall(new Position(12, 16));
        gui.drawWall(new Position(12, 18));
    }
}
