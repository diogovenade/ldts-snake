package model.game.elements;

import model.Direction;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WallTest {
    private Snake snakeMock;
    private Wall wall;

    @BeforeEach
    public void setUp() {
        wall = new Wall(5, 5);
        snakeMock = mock(Snake.class);
        when(snakeMock.getPosition()).thenReturn(new Position(3, 3));
    }

    @Test
    public void testGetPosition() {
        Position expectedPosition = new Position(5, 5);
        assertEquals(expectedPosition, wall.getPosition());
    }

}
