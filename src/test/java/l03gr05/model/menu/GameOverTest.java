package l03gr05.model.menu;

import l03gr05.model.menu.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {
    private GameOver gameOver;

    @BeforeEach
    public void setUp() {
        gameOver = new GameOver(47);
    }

    @Test
    public void testEntries() {
        assertEquals(2, gameOver.getNumberEntries());
        assertEquals("RESTART GAME", gameOver.getEntry(0));
        assertEquals("MAIN MENU", gameOver.getEntry(1));
    }

    @Test
    public void testIsSelectedRestart() {
        assertTrue(gameOver.isSelectedRestart());
        gameOver.nextEntry();
        assertFalse(gameOver.isSelectedRestart());
        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedRestart());
    }

    @Test
    public void isSelectedMain() {
        assertFalse(gameOver.isSelectedMain());
        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedMain());
        gameOver.nextEntry();
        assertFalse(gameOver.isSelectedMain());
    }

    @Test
    public void testGetScore() {
        assertEquals(47, gameOver.getScore());
    }
}
