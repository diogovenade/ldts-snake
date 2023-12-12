package model.game.elements;


import model.Direction;
import model.Position;
import l03gr05.model.Position;
import l03gr05.model.game.elements.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
    void testGetScore() {
        snake.increaseScore();
        snake.increaseScore();
        snake.increaseScore();
        snake.increaseScore();
        snake.increaseScore();
        assertEquals(5, snake.getScore());
    }

    @Test
    void testIncreaseScore() {
        assertEquals(0, snake.getScore());
        snake.increaseScore();
        assertEquals(1, snake.getScore());
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

    @Test
    public void testDirection(){
        snake.setDirection(Direction.Right);
        Direction expectedDirection = Direction.Right;
        assertEquals(expectedDirection, snake.getDirection());        
    }

    @Test
    public void testMoveHeadPosition(){
        snake.setDirection(Direction.Right);
        snake.move();
        Position expectedPosition = new Position(6, 10);
        assertEquals(expectedPosition, snake.getSnakeHead());   
    }

    public void testMoveBodyList(){
        snake.setDirection(Direction.Right);
        snake.setLength(4);
        snake.move();
        snake.move();
        snake.move();
        snake.setDirection(Direction.Down);
        snake.move();
        Position expectedPosition1 = new Position(6, 10);
        Position expectedPosition2 = new Position(7, 10);
        Position expectedPosition3 = new Position(8, 10);
        Position expectedPosition4 = new Position(8, 11);
        LinkedList<Position> expectedBody = new LinkedList<>();
        expectedBody.add(expectedPosition1);
        expectedBody.add(expectedPosition2);
        expectedBody.add(expectedPosition3);
        expectedBody.add(expectedPosition4);

        assertEquals(expectedBody, snake.getBody());   
    }
}
