package l03gr05.viewer;

import l03gr05.model.game.elements.Snake;
import l03gr05.viewer.game.*;
import l03gr05.gui.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SnakeViewerTest {
    private Snake snake;
    private SnakeViewer snakeViewer;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() {
        snake = new Snake(5, 5);
        snakeViewer = new SnakeViewer();
        gui = mock(LanternaGUI.class);
    }

    @Test
    public void drawSnake() {
        snakeViewer.draw(snake, gui);
        verify(gui, times(1)).drawSnake(snake);
    }

}