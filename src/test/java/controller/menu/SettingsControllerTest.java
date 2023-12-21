package controller.menu;

import l03gr05.Game;
import l03gr05.controller.menu.SettingsController;
import l03gr05.gui.Action;
import l03gr05.model.menu.Settings;
import l03gr05.states.MainMenuState;
import l03gr05.states.SettingsState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

public class SettingsControllerTest {
    private SettingsController settingsController;
    private State state;
    private Game game;

    @BeforeEach
    public void setUp() {
        settingsController = new SettingsController(new Settings());
        state = new SettingsState(new Settings());
        game = Mockito.mock(Game.class);
        Mockito.when(game.getState()).thenReturn(state);
    }

    @Test
    public void testStepSelectBack() {
        settingsController.getModel().previousEntry();
        settingsController.step(game, Action.Select, 100);
        verify(game).setState(isA(MainMenuState.class));
    }

    @Test
    public void testStepSelectSmall() {
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getSize(), "SMALL");
    }

    @Test
    public void testStepSelectMediumSize() {
        settingsController.getModel().nextEntry();
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getSize(), "MEDIUM");
    }

    @Test
    public void testStepSelectLarge() {
        for (int i = 0; i < 2; i++) {
            settingsController.getModel().nextEntry();
        }
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getSize(), "LARGE");
    }

    @Test
    public void testStepSelectSlow() {
        for (int i = 0; i < 3; i++) {
            settingsController.getModel().nextEntry();
        }
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getSpeed(), "SLOW");
    }

    @Test
    public void testStepSelectMediumSpeed() {
        for (int i = 0; i < 4; i++) {
            settingsController.getModel().nextEntry();
        }
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getSpeed(), "MEDIUM");
    }

    @Test
    public void testStepSelectFast() {
        for (int i = 0; i < 5; i++) {
            settingsController.getModel().nextEntry();
        }
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getSpeed(), "FAST");
    }

    @Test
    public void testStepSelectYes() {
        for (int i = 0; i < 6; i++) {
            settingsController.getModel().nextEntry();
        }
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getObstacles(), "YES");
    }

    @Test
    public void testStepSelectNo() {
        for (int i = 0; i < 7; i++) {
            settingsController.getModel().nextEntry();
        }
        settingsController.step(game, Action.Select, 100);
        assertEquals(settingsController.getModel().getObstacles(), "NO");
    }

    @Test
    public void testSelectUp() {
        settingsController.step(game, Action.Up, 100);
        assertTrue(settingsController.getModel().isSelected(8));
    }

    @Test
    public void testSelectDown() {
        settingsController.step(game, Action.Down, 100);
        assertTrue(settingsController.getModel().isSelected(1));
    }
}
