package controller.menu;

import l03gr05.Game;
import l03gr05.controller.menu.GameOverController;
import l03gr05.controller.menu.MainMenuController;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.GameOver;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.GameOverState;
import l03gr05.states.GameState;
import l03gr05.states.MainMenuState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

public class GameOverControllerTest {
    private GameOverController gameOverController;
    private State state;
    private Game game;

    @BeforeEach
    public void setUp() {
        gameOverController = new GameOverController(new GameOver(32));
        state = new GameOverState(new GameOver(32));
        game = Mockito.mock(Game.class);
        Mockito.when(game.getState()).thenReturn(state);
    }

    @Test
    public void testStepSelectRestart() throws IOException, URISyntaxException, FontFormatException {
        gameOverController.step(game, Action.Select, 100);
        verify(game).setState(isA(GameState.class));
    }

    @Test
    public void testStepSelectedMain() throws IOException, URISyntaxException, FontFormatException {
        gameOverController.getModel().nextEntry();
        gameOverController.step(game, Action.Select, 100);
        verify(game).setState(isA(MainMenuState.class));
    }

    @Test
    public void testSelectUp() throws IOException, URISyntaxException, FontFormatException {
        gameOverController.step(game, Action.Up, 100);
        assertTrue(gameOverController.getModel().isSelected(1));
    }

    @Test
    public void testSelectDown() throws IOException, URISyntaxException, FontFormatException {
        gameOverController.step(game, Action.Down, 100);
        assertTrue(gameOverController.getModel().isSelected(1));
    }
}
