package l03gr05.model.game;

import l03gr05.model.Position;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.game.elements.Fruit;
import l03gr05.model.game.elements.Snake;
import l03gr05.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new ClassicArenaBuilder(20, 20).createArena();
    }

    @Test
    void getters() {
        assertEquals(20, arena.getWidth());
        assertEquals(20, arena.getHeight());
    }

    @Test
    void getSnake() {
        assertNotNull(arena.getSnake());
    }

    @Test
    void setSnake() {
        Snake newSnake = new Snake(5, 5);
        arena.setSnake(newSnake);
        assertEquals(newSnake, arena.getSnake());
    }

    @Test
    void getFruit() {
        assertNotNull(arena.getFruit());
    }

    @Test
    void setFruit() {
        Fruit newFruit = new Fruit(8, 8);
        arena.setFruit(newFruit);
        assertEquals(newFruit, arena.getFruit());
    }

    @Test
    void getWalls() {
        assertNotNull(arena.getWalls());
        assertFalse(arena.getWalls().isEmpty());
    }

    @Test
    void setWalls() {
        List<Wall> newWalls = new ArrayList<>();
        newWalls.add(new Wall(1, 1));
        newWalls.add(new Wall(2, 2));

        arena.setWalls(newWalls);
        assertEquals(newWalls, arena.getWalls());
    }

    @Test
    void isFruit() {
        assertTrue(arena.isFruit(arena.getFruit().getPosition()));
    }

    @Test
    void isWall() {
        assertTrue(arena.isWall(arena.getWalls().get(0).getPosition()));
        assertFalse(arena.isWall(arena.getFruit().getPosition()));
    }

    @Test
    void isSnake() {
        for (Position position : arena.getSnake().getBody()) {
            if (position == arena.getSnake().getBody().get(0))
                continue;
            assertTrue(arena.isSnake(position));
        }
        assertFalse(arena.isSnake(arena.getFruit().getPosition()));
    }

    @Test
    void respawnFruit() {
        Position initialFruitPosition = arena.getFruit().getPosition();
        arena.respawnFruit();
        assertNotEquals(initialFruitPosition, arena.getFruit().getPosition());
        for (Position position : arena.getSnake().getBody()) {
            assertNotEquals(position, arena.getFruit().getPosition());
        }
        for (Wall wall : arena.getWalls()) {
            assertNotEquals(wall.getPosition(), arena.getFruit().getPosition());
        }
        assertTrue(arena.withinRange(arena.getFruit().getPosition()));
    }

    @Test
    void addObstacle() {
        int initialWallsSize = arena.getWalls().size();
        arena.addObstacle();
        assertEquals(initialWallsSize + 1, arena.getWalls().size());
        for (Position position : arena.getSnake().getBody()) {
            assertNotEquals(position, arena.getWalls().get(arena.getWalls().size() - 1).getPosition());
        }
        for (Wall wall : arena.getWalls()) {
            if (wall == arena.getWalls().get(arena.getWalls().size() - 1))
                break;
            assertNotEquals(arena.getWalls().get(arena.getWalls().size() - 1).getPosition(), wall.getPosition());
        }
        assertNotEquals(arena.getWalls().get(arena.getWalls().size() - 1).getPosition(), arena.getFruit().getPosition());
        assertTrue(arena.withinRange(arena.getWalls().get(arena.getWalls().size() - 1).getPosition()));
    }
}
