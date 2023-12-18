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

    @BeforeEach
    public void setUp() {
        fruit = new Fruit(5, 5);
    }

    @Test
    public void testGetPosition() {
        Position expectedPosition = new Position(5, 5);
        assertEquals(expectedPosition, fruit.getPosition());
    }

    @Test
    public void testRespawnValid() {
        fruit.respawn(4,4);
        Position oldPosition = new Position(5, 5);
        assertNotEquals(oldPosition, fruit.getPosition());
    }

}
