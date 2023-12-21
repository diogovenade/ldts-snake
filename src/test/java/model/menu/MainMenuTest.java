package model.menu;

import l03gr05.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
    }

    @Test
    public void testEntries() {
        assertEquals(3, mainMenu.getNumberEntries());
        assertEquals("START", mainMenu.getEntry(0));
        assertEquals("SETTINGS", mainMenu.getEntry(1));
        assertEquals("QUIT", mainMenu.getEntry(2));
    }

    @Test
    public void testIsSelectedStart() {
        assertTrue(mainMenu.isSelectedStart());
        mainMenu.nextEntry();
        assertFalse(mainMenu.isSelectedStart());
        mainMenu.nextEntry();
        assertFalse(mainMenu.isSelectedStart());
        mainMenu.nextEntry();
        assertTrue(mainMenu.isSelectedStart());
    }

    @Test
    public void testIsSelectedSettings() {
        assertFalse(mainMenu.isSelectedSettings());
        mainMenu.nextEntry();
        assertTrue(mainMenu.isSelectedSettings());
        mainMenu.nextEntry();
        assertFalse(mainMenu.isSelectedSettings());
    }

    @Test
    public void testIsSelectedQuit() {
        assertFalse(mainMenu.isSelectedExit());
        mainMenu.nextEntry();
        assertFalse(mainMenu.isSelectedExit());
        mainMenu.nextEntry();
        assertTrue(mainMenu.isSelectedExit());
    }

}
