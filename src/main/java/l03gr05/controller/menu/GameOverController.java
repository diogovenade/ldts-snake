package l03gr05.controller.menu;

import l03gr05.Game;
import l03gr05.controller.Controller;
import l03gr05.gui.Action;
import l03gr05.model.game.arena.ClassicArenaBuilder;
import l03gr05.model.menu.GameOver;
import l03gr05.model.menu.MainMenu;
import l03gr05.states.GameState;
import l03gr05.states.MainMenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void step(Game game, Action action, long time) throws IOException {
        switch(action) {
            case Up:
                getModel().previousEntry();
                break;
            case Down:
                getModel().nextEntry();
                break;
            case Select:
                if (getModel().isSelectedMain())
                    game.setState(new MainMenuState(new MainMenu(1, 1)));
                if (getModel().isSelectedRestart()) {
                    if (getModel().getSizeIndex() == 0)
                        game.setState(new GameState(new ClassicArenaBuilder(10, 10).createArena(), getModel().getSpeedIndex()));
                    if (getModel().getSizeIndex() == 1)
                        game.setState(new GameState(new ClassicArenaBuilder(20, 20).createArena(), getModel().getSpeedIndex()));
                    if (getModel().getSizeIndex() == 2)
                        game.setState(new GameState(new ClassicArenaBuilder(30, 30).createArena(), getModel().getSpeedIndex()));
                }
        }
    }

}
