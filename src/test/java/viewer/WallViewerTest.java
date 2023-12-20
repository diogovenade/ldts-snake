package viewer;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.game.elements.Wall;
import l03gr05.viewer.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WallViewerTest {
    private Wall wall;
    private WallViewer wallViewer;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() {
        wall = new Wall(3, 3);
        wallViewer = new WallViewer();
        gui = mock(LanternaGUI.class);
    }

    @Test
    public void drawWall() {
        wallViewer.draw(wall, gui);
        verify(gui, times(1)).drawWall(wall.getPosition());
    }

}
