import com.sun.tools.javac.Main;
import l03gr05.Game;
import l03gr05.gui.LanternaGUI;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.GameState;
import l03gr05.states.MainMenuState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameTest {
    private Game game;
    private LanternaGUI gui;
    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        gui = mock(LanternaGUI.class);
        game = new Game(gui);
    }
    @Test
    public void testGameInitialization() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(MainMenuState.class, game.getState().getClass());
    }

    @Test
    public void testSetState() throws IOException, URISyntaxException, FontFormatException {
        State newState = mock(State.class);
        game.setState(newState);
        assertEquals(newState, game.getState());
    }

    @Test
    public void testExitGame() throws IOException, URISyntaxException, FontFormatException {
        State newState = null;
        game.setState(newState);
        game.start();
        verify(gui, times(1)).close();
    }

    @Test
    public void testSetWindowSize() throws IOException, URISyntaxException, FontFormatException {
        game.setWindowSize(15, 15);
        verify(gui, times(1)).close();
    }
}
