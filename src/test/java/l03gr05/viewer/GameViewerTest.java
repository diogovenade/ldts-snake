package l03gr05.viewer;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.elements.Snake;
import l03gr05.viewer.game.GameViewer;
import l03gr05.viewer.game.SnakeViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class GameViewerTest {
    @Mock
    private Arena arena;

    @Mock
    private LanternaGUI gui;

    @Mock
    private Snake snake;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void drawElement() {
        GameViewer gameViewer = new GameViewer(arena);
        SnakeViewer snakeViewer = mock(SnakeViewer.class);
        gameViewer.drawElement(gui, snake, snakeViewer);

        verify(snakeViewer).draw(snake, gui);
    }
}

