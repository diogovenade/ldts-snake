package l03gr05;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.MainMenuState;
import l03gr05.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    private final LanternaGUI gui;
    private State state;
    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(30,30);
        this.state = new MainMenuState(new MainMenu(1,1));
    }
    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }

    public State getState() {
        return state;
    }
}
