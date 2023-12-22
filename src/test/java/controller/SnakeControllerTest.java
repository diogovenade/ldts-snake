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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SnakeControllerTest {
    private SnakeController snakeController;
    private Arena arena;
    private Game game;

    @BeforeEach
    public void setUp() {
        arena = new ClassicArenaBuilder(20, 20).createArena();
        snakeController = new SnakeController(arena);
        game = mock(Game.class);
    }

    @Test
    public void moveSnake() {
        State state = new GameState(arena);
        state.setSizeIndex(1);
        state.setSpeedIndex(1);
        state.setObstacles(false);
        when(game.getState()).thenReturn(state);

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
        when(game.getState()).thenReturn(state);

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
        when(game.getState()).thenReturn(state);

        arena.getSnake().setDirection(Direction.Up);
        snakeController.newdirSnakeRight();
        snakeController.moveSnake(false);

        assertTrue(snakeController.isGameOver());
    }

    @Test
    public void testCalculateMovementDuration() {
        assertEquals(200, snakeController.calculateMovementDuration(0));
        assertEquals(120, snakeController.calculateMovementDuration(1));
        assertEquals(80, snakeController.calculateMovementDuration(2));
    }

    @Test
    public void testNewDirUp() {
        snakeController.getModel().getSnake().setDirection(Direction.Left);
        snakeController.newdirSnakeUp();
        assertEquals(Direction.Up, snakeController.getModel().getSnake().getDirection());
    }

    @Test
    public void testNewDirDown() {
        snakeController.getModel().getSnake().setDirection(Direction.Left);
        snakeController.newdirSnakeDown();
        assertEquals(Direction.Down, snakeController.getModel().getSnake().getDirection());
    }

    @Test
    public void testNewDirRight() {
        snakeController.getModel().getSnake().setDirection(Direction.Up);
        snakeController.newdirSnakeRight();
        assertEquals(Direction.Right, snakeController.getModel().getSnake().getDirection());
    }

    @Test
    public void testStep() {
        Game game1 = mock(Game.class);
        State state1 = mock(GameState.class);
        when(state1.getSizeIndex()).thenReturn(1);
        when(state1.getSpeedIndex()).thenReturn(1);
        when(state1.isObstacles()).thenReturn(false);
        when(game1.getState()).thenReturn(state1);

        snakeController.getModel().getSnake().setDirection(Direction.Right);
        snakeController.step(game1, Action.Up, 100);

        assertEquals(Direction.Up, snakeController.getModel().getSnake().getDirection());

        snakeController.getModel().getSnake().setDirection(Direction.Left);
        snakeController.step(game1, Action.Down, 100);

        assertEquals(Direction.Down, snakeController.getModel().getSnake().getDirection());

        snakeController.getModel().getSnake().setDirection(Direction.Up);
        snakeController.step(game1, Action.Right, 100);

        assertEquals(Direction.Right, snakeController.getModel().getSnake().getDirection());

        Direction currentDirection = snakeController.getModel().getSnake().getDirection();
        snakeController.step(game1, Action.None, 100);

        assertEquals(currentDirection, snakeController.getModel().getSnake().getDirection());

        Game game2 = mock(Game.class);
        State state2 = mock(GameState.class);
        when(state2.getSizeIndex()).thenReturn(2);
        when(state2.getSpeedIndex()).thenReturn(2);
        when(state2.isObstacles()).thenReturn(true);
        when(game2.getState()).thenReturn(state2);

        Position currentPosition = snakeController.getModel().getSnake().getSnakeHead();

        snakeController.getModel().getSnake().setDirection(Direction.Right);
        snakeController.step(game2, Action.None, 100);

        assertEquals(currentPosition.getX() + 1, snakeController.getModel().getSnake().getSnakeHead().getX());
        assertEquals(currentPosition.getY(), snakeController.getModel().getSnake().getSnakeHead().getY());
    }
    
}
