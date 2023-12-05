package viewer.game;

import gui.LanternaGUI;
import model.game.elements.Snake;

public class SnakeViewer implements ElementViewer<Snake> {
    @Override
    public void draw(Snake snake, LanternaGUI gui) {
        gui.drawSnake(snake.getPosition());
    }
}
