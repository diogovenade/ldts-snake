package l03gr05.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import l03gr05.model.Position;
import l03gr05.model.game.elements.Snake;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI {
    private final Screen screen;
    int width, height;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
        this.width = width;
        this.height = height - 1;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public Action getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return Action.None;

        if (keyStroke.getKeyType() == KeyType.EOF) return Action.Quit;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return Action.Quit;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return Action.Up;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return Action.Right;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return Action.Down;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return Action.Left;

        if (keyStroke.getKeyType() == KeyType.Enter) return Action.Select;

        return Action.None;
    }

    public void drawFilledSquare(int x, int y, int size, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tg.putString(x + i, y + j, " ");
            }
        }
    }

    public void drawSnake(Snake snake) {
        for (Position segment : snake.getBody()) {
            if (segment == snake.getSnakeHead()){
                drawFilledSquare(segment.getX(), segment.getY(), 1, "#FFFFFF");
            }
            else {
                drawFilledSquare(segment.getX(), segment.getY(), 1, "#00FF00");
            }
        }
    }

    public void drawFruit(Position position) {
        drawFilledSquare(position.getX(), position.getY(), 1, "#FF0000");
    }

    public void drawWall(Position position) {
        drawFilledSquare(position.getX(), position.getY(), 1, "#0000FF");
    }

    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }
}
