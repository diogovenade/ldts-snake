import l03gr05.Game;
import l03gr05.gui.LanternaGUI;
import l03gr05.states.MainMenuState;
import l03gr05.states.State;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameTest {
    @Test
    public void testGameInitialization() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        assertEquals(MainMenuState.class, game.getState().getClass());
    }

    @Test
    public void testSetState() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        State newState = mock(State.class);
        game.setState(newState);
        assertEquals(newState, game.getState());
    }
}
