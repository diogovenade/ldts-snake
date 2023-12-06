package model.game.elements;

import l03gr05.model.Position;
import l03gr05.model.game.elements.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

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
    @Test
    void testSnakeBody() {
        LinkedList<Position> expectedBody = new LinkedList<>();
        Position p1 = new Position(5, 10);
        Position p2 = new Position(4, 10);
        Position p3 = new Position(3, 10);
        expectedBody.add(p1);
        expectedBody.add(p2);
        expectedBody.add(p3);
        assertEquals(expectedBody, snake.getBody());
    }
}
