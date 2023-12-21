package controller;

import l03gr05.Game;
import l03gr05.controller.game.SnakeController;
import l03gr05.gui.Action;
import l03gr05.model.Direction;
import l03gr05.model.Position;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.game.elements.Fruit;
import l03gr05.model.game.elements.Snake;
import l03gr05.states.GameState;
import l03gr05.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnakeControllerTest {
    private SnakeController snakeController;
    private Arena arena;
    private Game game;

    @BeforeEach
    public void setUp() {
        arena = new ClassicArenaBuilder(20, 20).createArena();
        snakeController = new SnakeController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    public void moveSnake() {
        State state = new GameState(arena);
        state.setSizeIndex(1);
        state.setSpeedIndex(1);
        state.setObstacles(false);
        Mockito.when(game.getState()).thenReturn(state);

        Position currentPosition = arena.getSnake().getSnakeHead();

        arena.getSnake().setDirection(Direction.Up);
        snakeController.newdirSnakeRight();
        snakeController.moveSnake(false);

        assertEquals(currentPosition.getX() + 1, arena.getSnake().getSnakeHead().getX());
        assertEquals(currentPosition.getY(), arena.getSnake().getSnakeHead().getY());
    }

    @Test
    public void moveSnakeToFruit() {
        arena.setFruit(new Fruit(arena.getSnake().getSnakeHead().getX() + 1, arena.getSnake().getSnakeHead().getY()));
        State state = new GameState(arena);
        state.setSizeIndex(1);
        state.setSpeedIndex(1);
        state.setObstacles(false);
        Mockito.when(game.getState()).thenReturn(state);

        Position currentPosition = arena.getSnake().getSnakeHead();
        int currentScore = arena.getSnake().getScore();

        arena.getSnake().setDirection(Direction.Up);
        snakeController.newdirSnakeRight();
        snakeController.moveSnake(false);

        assertEquals(currentPosition.getX() + 1, arena.getSnake().getSnakeHead().getX());
        assertEquals(currentPosition.getY(), arena.getSnake().getSnakeHead().getY());
        assertEquals(currentScore + 1, arena.getSnake().getScore());
    }

    @Test
    public void moveSnakeToWall() {
        arena.setSnake(new Snake(18, 5));
        State state = new GameState(arena);
        state.setSizeIndex(1);
        state.setSpeedIndex(1);
        state.setObstacles(true);
        Mockito.when(game.getState()).thenReturn(state);

        arena.getSnake().setDirection(Direction.Up);
        snakeController.newdirSnakeRight();
        snakeController.moveSnake(false);

        assertTrue(snakeController.isGameOver());
    }
    
}
