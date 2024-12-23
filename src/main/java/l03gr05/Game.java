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
        new Game(new LanternaGUI(20,20)).start();
    }
    private LanternaGUI gui;
    private State<?> state;
    public Game(LanternaGUI gui) throws IOException, URISyntaxException, FontFormatException {
        this.gui = gui;
        this.state = new MainMenuState(new MainMenu());
    }
    public void setState(State<?> state) {
        this.state = state;
    }
    public void start() throws IOException, URISyntaxException, FontFormatException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
            gui.refresh();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }

        gui.close();
    }

    public State<?> getState() {
        return state;
    }

    public void setWindowSize(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        gui.close();
        this.gui = new LanternaGUI(width, height);
    }
}
