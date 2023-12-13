package l03gr05.model.game.arena;

import l03gr05.model.Position;
import l03gr05.model.game.elements.Snake;
import l03gr05.model.game.elements.Fruit;
import l03gr05.model.game.elements.Wall;

import java.util.List;
import java.util.Random;

public class Arena {
    private Snake snake;
    private Fruit fruit;
    private List<Wall> walls;
    private int width, height;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isFruit(Position position) {
        return fruit.getPosition().equals(position);
    }

    public boolean isWall(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSnake(Position position) {
        List<Position> snakeBody = snake.getBody();
        int bodySize = snakeBody.size();
        for (int i = 1; i < bodySize; i++) {
            Position p = snakeBody.get(i);
            if (p.equals(position)) {
                return true;
            }
        }

        return false;
    }

    public void respawnFruit() {
        Position currentPosition = fruit.getPosition();
        while (true) {
            fruit.respawn(4, 4);
            boolean positionOccupied = walls.stream().anyMatch(wall -> wall.getPosition().equals(fruit.getPosition())) ||
                    snake.getBody().stream().anyMatch(segment -> segment.equals(fruit.getPosition()));

            if (!positionOccupied && !(fruit.getPosition().equals(currentPosition))) {
                break;
            }
        }
    }

    public void addObstacle() {
        boolean positionOccupied;

        while (true) {
            Wall newWall = new Wall(new Random().nextInt(width), new Random().nextInt(height));

            boolean nearSnakeHead = snake.getBody().stream()
                    .anyMatch(segment -> Math.abs(segment.getX() - newWall.getPosition().getX()) <= 1 &&
                            Math.abs(segment.getY() - newWall.getPosition().getY()) <= 1);

            positionOccupied = walls.stream().anyMatch(wall -> wall.getPosition().equals(newWall.getPosition())) ||
                    snake.getBody().stream().anyMatch(segment -> segment.equals(newWall.getPosition()));

            if (!positionOccupied && !nearSnakeHead) {
                walls.add(newWall);
                break;
            }
        }
    }
}

