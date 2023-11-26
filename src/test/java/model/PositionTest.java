package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        int x = 5;
        int y = 10;
        position = new Position(x, y);
    }

    @Test
    void testGetX() {
        assertEquals(5, position.getX());
    }

    @Test
    void testGetY() {
        assertEquals(10, position.getY());
    }

    @Test
    void testGetLeft() {
        Position leftPosition = new Position(4, 10);
        assertEquals(leftPosition, position.getLeft());
    }

    @Test
    void testGetRight() {
        Position rightPosition = new Position(6, 10);
        assertEquals(rightPosition, position.getRight());
    }

    @Test
    void testGetUp() {
        Position upPosition = new Position(5, 9);
        assertEquals(upPosition, position.getUp());
    }

    @Test
    void testGetDown() {
        Position downPosition = new Position(5, 11);
        assertEquals(downPosition, position.getDown());
    }

    @Test
    void testEquals() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(6, 10);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }
}
