package l03gr05.controller.game;

import l03gr05.Game;
import l03gr05.gui.Action;
import l03gr05.model.Direction;
import l03gr05.model.Position;
import l03gr05.model.game.arena.Arena;

public class SnakeController extends GameController {
    private boolean gameOver = false;
    public SnakeController(Arena arena) {
        super(arena);
    }

    private void moveSnake() {
        Position nextPosition = getModel().getSnake().calculateNewHead();
        if (getModel().isFruit(nextPosition)) {
            getModel().getSnake().increaseLength();
            getModel().getSnake().increaseScore();
            getModel().respawnFruit();
            getModel().getSnake().move();
        }
        else if (getModel().isSnake(nextPosition) || getModel().isWall(nextPosition)) {
            gameOver = true;
        }
        else {
            getModel().getSnake().move();
        }
    }

    public void moveSnakeUp() {
        if (getModel().getSnake().getDirection() == Direction.Down)
            return;
        getModel().getSnake().setDirection(Direction.Up);
        moveSnake();
    }

    public void moveSnakeDown() {
        if (getModel().getSnake().getDirection() == Direction.Up)
            return;
        getModel().getSnake().setDirection(Direction.Down);
        moveSnake();
    }

    public void moveSnakeLeft() {
        if (getModel().getSnake().getDirection() == Direction.Right)
            return;
        getModel().getSnake().setDirection(Direction.Left);
        moveSnake();
    }

    public void moveSnakeRight() {
        if (getModel().getSnake().getDirection() == Direction.Left)
            return;
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

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
