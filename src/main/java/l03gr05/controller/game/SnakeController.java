package l03gr05.controller.game;

import l03gr05.Game;
import l03gr05.gui.Action;
import l03gr05.model.Direction;
import l03gr05.model.Position;
import l03gr05.model.game.arena.Arena;

public class SnakeController extends GameController {
    public SnakeController(Arena arena) {
        super(arena);
    }

    private void moveSnake() {
        Position nextPosition = getModel().getSnake().calculateNewHead();
        if (getModel().isFruit(nextPosition)) {
            getModel().getSnake().increaseLength();
            getModel().getSnake().increaseScore();
            getModel().respawnFruit();
        }
        getModel().getSnake().move();
    }

    public void moveSnakeUp() {
        getModel().getSnake().setDirection(Direction.Up);
        moveSnake();
    }

    public void moveSnakeDown() {
        getModel().getSnake().setDirection(Direction.Down);
        moveSnake();
    }

    public void moveSnakeLeft() {
        getModel().getSnake().setDirection(Direction.Left);
        moveSnake();
    }

    public void moveSnakeRight() {
        getModel().getSnake().setDirection(Direction.Right);
        moveSnake();
    }

    @Override
    public void step(Game game, Action action, long time) {
        if (action == Action.Up) moveSnakeUp();
        if (action == Action.Right) moveSnakeRight();
        if (action == Action.Down) moveSnakeDown();
        if (action == Action.Left) moveSnakeLeft();
    }
}
