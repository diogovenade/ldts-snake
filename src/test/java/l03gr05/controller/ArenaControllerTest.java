package l03gr05.controller;

import l03gr05.Game;
import l03gr05.controller.game.ArenaController;
import l03gr05.controller.game.SnakeController;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.GameOver;
import l03gr05.states.GameOverState;
import l03gr05.states.GameState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.verify;

public class ArenaControllerTest {
    private ArenaController arenaController;
    private Arena arena;
    private SnakeController snakeController;

    @BeforeEach
    public void setUp() {
        arena = new ClassicArenaBuilder(20, 20).createArena();
        snakeController = Mockito.mock(SnakeController.class);
        Mockito.when(snakeController.isGameOver()).thenReturn(false);
        arenaController = new ArenaController(arena, snakeController);
    }

    @Test
    public void stepGameOver() throws IOException, URISyntaxException, FontFormatException {
        Game game1 = Mockito.mock(Game.class);
        State state1 = new GameState(arena);
        state1.setSizeIndex(1);
        state1.setSpeedIndex(1);
        state1.setObstacles(true);
        Mockito.when(game1.getState()).thenReturn(state1);

        arenaController.step(game1, Action.Quit, 100);

        verify(game1, Mockito.times(1)).setState(Mockito.any(GameOverState.class));

        Game game2 = Mockito.mock(Game.class);
        State state2 = new GameState(arena);
        state2.setSizeIndex(0);
        state2.setSpeedIndex(2);
        state2.setObstacles(false);
        Mockito.when(game2.getState()).thenReturn(state2);

        arenaController.step(game2, Action.Quit, 100);

        verify(game2, Mockito.times(1)).setWindowSize(20, 20);
    }

    @Test
    public void stepNotGameOver() throws IOException, URISyntaxException, FontFormatException {
        Game game1 = Mockito.mock(Game.class);
        State state1 = new GameState(arena);
        state1.setSizeIndex(1);
        state1.setSpeedIndex(1);
        state1.setObstacles(true);
        Mockito.when(game1.getState()).thenReturn(state1);

        arenaController.step(game1, Action.Up, 100);

        verify(snakeController, Mockito.times(1)).step(game1, Action.Up, 100);
    }
}
