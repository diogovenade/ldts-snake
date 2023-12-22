package l03gr05;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.menu.GameOver;
import l03gr05.states.GameOverState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        gui = Mockito.mock(LanternaGUI.class);
        game = new Game(gui);
    }

    @Test
    public void testSetState() {
        State state = new GameOverState(new GameOver(12));
        game.setState(state);
        assertEquals(state, game.getState());
    }
}
