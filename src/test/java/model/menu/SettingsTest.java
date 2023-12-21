package model.menu;

import l03gr05.model.menu.Settings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SettingsTest {
    private Settings settings;

    @BeforeEach
    public void setUp() {
        settings = new Settings();
    }

    @Test
    public void testEntries() {
        assertEquals(9, settings.getNumberEntries());
        assertEquals("SMALL", settings.getEntry(0));
        assertEquals("MEDIUM", settings.getEntry(1));
        assertEquals("LARGE", settings.getEntry(2));
        assertEquals("SLOW", settings.getEntry(3));
        assertEquals("MEDIUM", settings.getEntry(4));
        assertEquals("FAST", settings.getEntry(5));
        assertEquals("YES", settings.getEntry(6));
        assertEquals("NO", settings.getEntry(7));
        assertEquals("BACK", settings.getEntry(8));
    }

    @Test
    public void isSelectedSmall() {
        assertTrue(settings.isSelectedSmall());
        settings.nextEntry();
        assertFalse(settings.isSelectedSmall());
    }

    @Test
    public void isSelectedMediumSize() {
        assertFalse(settings.isSelectedMedium());
        settings.nextEntry();
        assertTrue(settings.isSelectedMedium());
        settings.nextEntry();
        assertFalse(settings.isSelectedMedium());
    }

    @Test
    public void isSelectedLarge() {
        assertFalse(settings.isSelectedLarge());
        for (int i = 0; i < 2; i++) {
            settings.nextEntry();
        }
        assertTrue(settings.isSelectedLarge());
        settings.nextEntry();
        assertFalse(settings.isSelectedLarge());
    }

    @Test
    public void isSelectedSlow() {
        assertFalse(settings.isSelectedSlow());
        for (int i = 0; i < 3; i++) {
            settings.nextEntry();
        }
        assertTrue(settings.isSelectedSlow());
        settings.nextEntry();
        assertFalse(settings.isSelectedSlow());
    }

    @Test
    public void isSelectedMediumSpeed() {
        assertFalse(settings.isSelectedMediumSpeed());
        for (int i = 0; i < 4; i++) {
            settings.nextEntry();
        }
        assertTrue(settings.isSelectedMediumSpeed());
        settings.nextEntry();
        assertFalse(settings.isSelectedMediumSpeed());
    }

    @Test
    public void isSelectedFast() {
        assertFalse(settings.isSelectedFast());
        for (int i = 0; i < 5; i++) {
            settings.nextEntry();
        }
        assertTrue(settings.isSelectedFast());
        settings.nextEntry();
        assertFalse(settings.isSelectedFast());
    }

    @Test
    public void isSelectedYes() {
        assertFalse(settings.isSelectedYes());
        for (int i = 0; i < 6; i++) {
            settings.nextEntry();
        }
        assertTrue(settings.isSelectedYes());
        settings.nextEntry();
        assertFalse(settings.isSelectedYes());
    }

    @Test
    public void isSelectedNo() {
        assertFalse(settings.isSelectedNo());
        for (int i = 0; i < 7; i++) {
            settings.nextEntry();
        }
        assertTrue(settings.isSelectedNo());
        settings.nextEntry();
        assertFalse(settings.isSelectedNo());
    }

    @Test
    public void isSelectedBack() {
        assertFalse(settings.isSelectedBack());
        for (int i = 0; i < 8; i++) {
            settings.nextEntry();
        }
        assertTrue(settings.isSelectedBack());
        settings.nextEntry();
        assertFalse(settings.isSelectedBack());
    }

    @Test
    public void testSize() {
        settings.setSize("SMALL");
        assertEquals("SMALL", settings.getSize());
    }

    @Test
    public void testSpeed() {
        settings.setSpeed("FAST");
        assertEquals("FAST", settings.getSpeed());
    }

    @Test
    public void testObstacles() {
        settings.setObstacles("YES");
        assertEquals("YES", settings.getObstacles());
    }
}
