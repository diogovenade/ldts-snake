package l03gr05.model.game;


import l03gr05.model.*;
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
        for (int i = 0; i < 5; i++) {
            snake.increaseScore();
        }
        assertEquals(5, snake.getScore());
    }

    @Test
    void testSnakeBody() {
        LinkedList<Position> expectedBody = new LinkedList<>();
        Position p1 = new Position(3, 10);
        Position p2 = new Position(4, 10);
        Position p3 = new Position(5, 10);
        expectedBody.add(p1);
        expectedBody.add(p2);
        expectedBody.add(p3);
        assertEquals(expectedBody, snake.getBody());
    }

    @Test
    public void testDirection(){
        snake.setDirection(Direction.Right);
        Direction expectedDirection = Direction.Right;
        assertEquals(expectedDirection, snake.getDirection());        
    }

    @Test
    public void testMoveSnake(){
        snake.setDirection(Direction.Right);
        snake.move();
        Position positionRight = new Position(6, 10);
        assertEquals(positionRight, snake.getSnakeHead());
        snake.setDirection(Direction.Up);
        snake.move();
        Position positionUp = new Position(6, 9);
        assertEquals(positionUp, snake.getSnakeHead());
        snake.setDirection(Direction.Left);
        snake.move();
        Position positionLeft = new Position(5, 9);
        assertEquals(positionLeft, snake.getSnakeHead());
        snake.setDirection(Direction.Down);
        snake.move();
        Position positionDown = new Position(5, 10);
        assertEquals(positionDown, snake.getSnakeHead());
    }

    @Test
    public void testMoveBodyList(){
        snake.setDirection(Direction.Right);
        for (int i = 0; i < 3; i++) {
            snake.move();
        }
        snake.setDirection(Direction.Down);
        snake.move();
        Position expectedPosition2 = new Position(7, 10);
        Position expectedPosition3 = new Position(8, 10);
        Position expectedPosition4 = new Position(8, 11);
        LinkedList<Position> expectedBody = new LinkedList<>();
        expectedBody.add(expectedPosition2);
        expectedBody.add(expectedPosition3);
        expectedBody.add(expectedPosition4);

        assertEquals(expectedBody, snake.getBody());
    }
}
