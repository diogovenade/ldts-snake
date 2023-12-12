package viewer;

import model.game.elements.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SnakeViewerTest {
    private Snake snake;
    private SnakeViewer snakeViewer;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        snake = new Snake(5, 5);
        snakeViewer = new SnakeViewer();
        gui = mock(GUI.class);
    }

    @Test
    public void drawSnake() {
        snakeViewer.drawSnake(snake, gui);
        verify(gui, times(1)).drawSnake(snake.getBody());
    }

}