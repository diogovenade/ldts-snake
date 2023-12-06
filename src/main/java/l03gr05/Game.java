package l03gr05;

import l03gr05.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20,20);
    }
}
