package l03gr05.viewer.game;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.game.elements.Snake;

public class SnakeViewer implements ElementViewer<Snake> {
    @Override
    public void draw(Snake snake, LanternaGUI gui) {
        gui.drawSnake(snake);
    }
}
