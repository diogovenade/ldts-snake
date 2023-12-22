package l03gr05.viewer.menu;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.menu.GameOver;
import l03gr05.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GameOverViewerTest {
    private GameOverViewer gameOverViewer;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() {
        gameOverViewer = new GameOverViewer(new GameOver(23));
        gui = mock(LanternaGUI.class);
    }

    @Test
    public void testDrawElements() {
        gameOverViewer.drawElements(gui);
        verify(gui, times(4)).drawText(any(), any(), any());
    }
}
