package l03gr05.viewer.menu;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.Position;
import l03gr05.model.game.elements.Fruit;
import l03gr05.model.game.elements.Snake;
import l03gr05.model.menu.MainMenu;
import l03gr05.viewer.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        drawSnake(gui);
        drawFruit(gui);

        drawSnakeTitle(gui);

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7 + i * 2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }

    public void drawSnakeTitle(LanternaGUI gui) {
        String snakeTitle = "SNAKE";

        int startX = (gui.getWidth() - snakeTitle.length()) / 2;
        int startY = 2;

        for (int i = -1; i <= snakeTitle.length(); i++) {
            for (int j = -1; j <= 1; j++) {
                gui.drawText(new Position(startX + i, startY + j), "*", "#FFFFFF");
            }
        }

        gui.drawText(new Position(startX, startY), snakeTitle, "#00DD07");
    }

    public void drawSnake(LanternaGUI gui) {
        Snake snake = new Snake(9, 15);
        int i = 4;
        while (i != 0) {
            snake.addPosition();
            i--;
        }
        gui.drawSnake(snake);
    }

    public void drawFruit(LanternaGUI gui) {
        gui.drawFruit(new Fruit(12, 15).getPosition());
    }
}
