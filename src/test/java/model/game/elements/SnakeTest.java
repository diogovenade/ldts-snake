package model.game.elements;

import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {
    private Snake snake;

    @BeforeEach
    void setUp() {
        int x = 5;
        int y = 10;
        snake = new Snake(x, y);
    }

    @Test
    void testGetSnakeHead() {
        Position expectedHead = new Position(5, 10);
        assertEquals(expectedHead, snake.getSnakeHead());
    }

    @Test
    void testIncreaseScore() {
        assertEquals(0, snake.getScore());
        snake.increaseScore();
        assertEquals(1, snake.getScore());
    }

    @Test
    void testGetScore() {
        assertEquals(0, snake.getScore());
    }

    @Test
    void testSnakeInitialization() {
        Position expectedHead = new Position(5, 10);
        assertEquals(expectedHead, snake.getSnakeHead());
        assertEquals(0, snake.getScore());
    }
}
