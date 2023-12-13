package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l03gr05.model.*;
import l03gr05.model.game.elements.*;
import l03gr05.gui.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }


    /* @Test
    void drawFilledSquare() {
        gui.drawFilledSquare(1,1,1,"#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, " ");
    } */

    /* @Test
    void drawSnake() {
        gui.drawSnake(new Snake(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 0));
    } */

    /* @Test
    void drawFruit() {
        gui.drawFruit(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
    } */

    /* @Test
    void drawWall() {
        gui.drawWall(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 255));
    } */

    @Test
    void drawText() {
        gui.drawText(new Position(1,1), "Hello World", "#01FFFE");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(1, 255, 254));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

}
