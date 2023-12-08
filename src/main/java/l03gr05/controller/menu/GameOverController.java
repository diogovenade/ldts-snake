package l03gr05.controller.menu;

import l03gr05.Game;
import l03gr05.controller.Controller;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.GameOver;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.GameState;
import l03gr05.states.MainMenuState;
import l03gr05.states.State;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException {
        State state = game.getState();
        int speedIndex = state.getSpeedIndex();
        int sizeIndex = state.getSizeIndex();
        switch(action) {
            case Up:
                getModel().previousEntry();
                break;
            case Down:
                getModel().nextEntry();
                break;
            case Select:
                if (getModel().isSelectedMain())
                    game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedRestart()) {
                    State newState = new GameState(new ClassicArenaBuilder(20,20).createArena());
                    newState.setSpeedIndex(speedIndex);
                    newState.setSizeIndex(sizeIndex);
                    game.setState(newState);
                }
        }
    }

}
