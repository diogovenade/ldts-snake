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
    private Direction lastDirection = Direction.Right;
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

    public void newdirSnakeUp() {
        if (lastDirection != Direction.Down) {
            getModel().getSnake().setDirection(Direction.Up);
        }
    }

    public void newdirSnakeDown() {
        if (lastDirection != Direction.Up) {
            getModel().getSnake().setDirection(Direction.Down);
        }
    }

    public void newdirSnakeLeft() {
        if (lastDirection != Direction.Right) {
            getModel().getSnake().setDirection(Direction.Left);
        }
    }

    public void newdirSnakeRight() {
        if (lastDirection != Direction.Left) {
            getModel().getSnake().setDirection(Direction.Right);
        }
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
            lastDirection = getModel().getSnake().getDirection();
        }
        if (action == Action.Up) {
            newdirSnakeUp();
        }
        if (action == Action.Right) {
            newdirSnakeRight();
        }
        if (action == Action.Down) {
            newdirSnakeDown();
        }
        if (action == Action.Left) {
            newdirSnakeLeft();
        }
    }

    private long calculateMovementDuration(int speedIndex) {
        switch (speedIndex) {
            case 0:
                return 200;
            case 1:
                return 120;
            case 2:
                return 80;
            case 3:
                return 500;
            default:
                return 120;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

}
