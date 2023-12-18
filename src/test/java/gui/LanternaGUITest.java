package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternaGUITest {
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        Screen screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

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

}
