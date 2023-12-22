package l03gr05.controller.menu;

import l03gr05.Game;
import l03gr05.controller.menu.MainMenuController;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.GameState;
import l03gr05.states.MainMenuState;
import l03gr05.states.SettingsState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private Arena arena;
    private State state;
    private Game game;

    @BeforeEach
    public void setUp() {
        mainMenuController = new MainMenuController(new MainMenu());
        arena = new ClassicArenaBuilder(20, 20).createArena();
        state = new MainMenuState(new MainMenu());
        game = Mockito.mock(Game.class);
        Mockito.when(game.getState()).thenReturn(state);
    }

    @Test
    public void testStepSelectStart() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.step(game, Action.Select, 100);
        verify(game).setState(isA(GameState.class));
    }

    @Test
    public void testStepSelectSettings() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.getModel().nextEntry();
        mainMenuController.step(game, Action.Select, 100);
        verify(game).setState(isA(SettingsState.class));
    }

    @Test
    public void testStepSelectExit() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.getModel().previousEntry();
        mainMenuController.step(game, Action.Select, 100);
        verify(game).setState(isNull());
    }

    @Test
    public void testSelectUp() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.step(game, Action.Up, 100);
        assertTrue(mainMenuController.getModel().isSelected(2));
    }

    @Test
    public void testSelectDown() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.step(game, Action.Down, 100);
        assertTrue(mainMenuController.getModel().isSelected(1));
    }


}
