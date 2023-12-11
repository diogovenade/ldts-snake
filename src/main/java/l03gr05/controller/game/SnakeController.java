package l03gr05.controller.game;

import l03gr05.Game;
import l03gr05.gui.Action;
import l03gr05.model.Direction;
import l03gr05.model.Position;
import l03gr05.model.game.arena.Arena;
import l03gr05.states.GameState;
import l03gr05.states.State;

public class SnakeController extends GameController {
    private boolean gameOver = false;
    private long lastMovement;
    public SnakeController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    private void moveSnake(boolean obstacles) {
        Position nextPosition = getModel().getSnake().calculateNewHead();

        if (getModel().isSnake(nextPosition) || getModel().isWall(nextPosition)) {
            gameOver = true;
            return;
        }

        if (getModel().isFruit(nextPosition)) {
            getModel().getSnake().increaseLength();
            getModel().getSnake().increaseScore();
            getModel().respawnFruit();
            if (obstacles)
                getModel().addObstacle();
        }

        getModel().getSnake().move();
    }

    public void moveSnakeUp(boolean obstacles) {
        if (getModel().getSnake().getDirection() == Direction.Down || getModel().getSnake().getDirection() == Direction.Up)
            return;
        getModel().getSnake().setDirection(Direction.Up);;
    }

    public void moveSnakeDown(boolean obstacles) {
        if (getModel().getSnake().getDirection() == Direction.Up || getModel().getSnake().getDirection() == Direction.Down)
            return;
        getModel().getSnake().setDirection(Direction.Down);;
    }

    public void moveSnakeLeft(boolean obstacles) {
        if (getModel().getSnake().getDirection() == Direction.Right || getModel().getSnake().getDirection() == Direction.Left)
            return;
        getModel().getSnake().setDirection(Direction.Left);;
    }

    public void moveSnakeRight(boolean obstacles) {
        if (getModel().getSnake().getDirection() == Direction.Left || getModel().getSnake().getDirection() == Direction.Right)
            return;
        getModel().getSnake().setDirection(Direction.Right);
    }

    @Override
    public void step(Game game, Action action, long time) {
        State state = game.getState();
        int speedIndex = state.getSpeedIndex();
        boolean obstacles = state.isObstacles();
        long movementDuration = calculateMovementDuration(speedIndex);

        if (time - lastMovement > movementDuration && !isGameOver()) {
            moveSnake(obstacles);
            lastMovement = time;
        }
        if (action == Action.Up) moveSnakeUp(obstacles);
        if (action == Action.Right) moveSnakeRight(obstacles);
        if (action == Action.Down) moveSnakeDown(obstacles);
        if (action == Action.Left) moveSnakeLeft(obstacles);
    }

    private long calculateMovementDuration(int speedIndex) {
        switch (speedIndex) {
            case 0:
                return 500;
            case 1:
                return 300;
            case 2:
                return 100;
            default:
                return 500;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
