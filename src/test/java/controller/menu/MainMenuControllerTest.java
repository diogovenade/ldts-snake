package controller.menu;

import com.sun.tools.javac.Main;
import l03gr05.Game;
import l03gr05.controller.menu.MainMenuController;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.GameState;
import l03gr05.states.SettingsState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        state = new GameState(arena);
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


}
