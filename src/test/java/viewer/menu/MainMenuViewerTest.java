package viewer.menu;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.menu.MainMenu;
import l03gr05.viewer.menu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MainMenuViewerTest {
    private MainMenuViewer mainMenuViewer;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() {
        mainMenuViewer = new MainMenuViewer(new MainMenu());
        gui = mock(LanternaGUI.class);
    }

    @Test
    public void testDrawElements() {
        mainMenuViewer.drawElements(gui);
        verify(gui, times(22 + mainMenuViewer.getModel().getNumberEntries())).drawText(any(), any(), any());
    }

    @Test
    public void testDrawSnakeTitle() {
        mainMenuViewer.drawSnakeTitle(gui);
        verify(gui, times(22)).drawText(any(), any(), any());
    }

    @Test
    public void testDrawSnake() {
        mainMenuViewer.drawSnake(gui);
        verify(gui, times(1)).drawSnake(any());
    }

    @Test
    public void testDrawFruit() {
        mainMenuViewer.drawFruit(gui);
        verify(gui, times(1)).drawFruit(any());
    }
}
