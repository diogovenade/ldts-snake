package l03gr05.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import l03gr05.gui.Action;
import l03gr05.model.*;
import l03gr05.model.game.elements.*;
import l03gr05.gui.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LanternaGUITest {
    private LanternaGUI gui;
    private TextGraphics tg;
    private Screen screen;

    @BeforeEach
    void setUp() {
        screen = mock(Screen.class);
        tg = mock(TextGraphics.class);

        when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }


    @Test
    void drawFilledSquare() {
        gui.drawFilledSquare(1, 1, 1, "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, " ");
    }

    @Test
    void drawSnake() {
        Snake snake = new Snake(5, 5);
        gui.drawSnake(snake);

        Mockito.verify(tg, Mockito.times(3)).setBackgroundColor(Mockito.any());
        Mockito.verify(tg, Mockito.times(1)).putString(5, 5, " ");
        Mockito.verify(tg, Mockito.times(1)).putString(4, 5, " ");
        Mockito.verify(tg, Mockito.times(1)).putString(3, 5, " ");
    }

    @Test
    void drawFruit() {
        gui.drawFruit(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, " ");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, " ");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1,1), "Test", "#000000");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Test");
    }

    @Test
    void testGetNextAction() throws IOException {
        when(screen.pollInput()).thenReturn(null);
        assertEquals(Action.None, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(Action.Quit, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke('q', true, true));
        assertEquals(Action.Quit, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(Action.Up, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(Action.Down, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
        assertEquals(Action.Right, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(Action.Left, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
        assertEquals(Action.Select, gui.getNextAction());
    }

    @Test
    void testClear() {
        gui.clear();
        verify(screen, times(1)).clear();
    }

    @Test
    void testRefresh() throws IOException {
        gui.refresh();
        verify(screen, times(1)).refresh();
    }

    @Test
    void testClose() throws IOException {
        gui.close();
        verify(screen, times(1)).close();
    }

}
