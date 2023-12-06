package model.game.elements;

import l03gr05.model.Position;
import l03gr05.model.game.elements.Fruit;
import l03gr05.model.game.elements.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class FruitTest {
    private Fruit fruit;
    private Snake snakeMock;

    @BeforeEach
    public void setUp() {
        fruit = new Fruit(5, 5);
        snakeMock = mock(Snake.class);
        when(snakeMock.getPosition()).thenReturn(new Position(3, 3));
    }

    @Test
    public void testGetPosition() {
        Position expectedPosition = new Position(5, 5);
        assertEquals(expectedPosition, fruit.getPosition());
    }

    @Test
    public void testChangePositionValid() {
        fruit.changePosition(7, 7);
        Position expectedPosition = new Position(7, 7);
        assertEquals(expectedPosition, fruit.getPosition());
    }

    @Test
    public void testChangePositionSnakeOverlap() {
        when(snakeMock.getPosition()).thenReturn(new Position(3, 3));
        fruit.changePosition(3, 3);
        Position expectedPosition = new Position(5, 5);
        assertNotEquals(expectedPosition, fruit.getPosition());
    }

    @Test
    public void testChangeToRandomPosition() {
        when(snakeMock.getPosition()).thenReturn(new Position(3, 3));
        fruit.changeToRandomPosition();
        verify(snakeMock, atLeastOnce()).getPosition();
        assertNotEquals(snakeMock.getPosition(), fruit.getPosition());
    }
}
