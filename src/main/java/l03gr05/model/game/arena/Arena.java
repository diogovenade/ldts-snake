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
        for (Position p : snake.getBody()) {
            if (p.equals(position)) {
                return true;
            }
        }
        return false;
    }

    public void respawnFruit() {
        do {
            fruit.respawn(width, height);
        } while (isWall(fruit.getPosition()) || isSnake(fruit.getPosition()));
    }

    public void addObstacle() {
        Wall newWall = new Wall(new Random().nextInt(width), new Random().nextInt(height));

        boolean positionOccupied = walls.stream().anyMatch(wall -> wall.getPosition().equals(newWall.getPosition())) ||
                snake.getBody().stream().anyMatch(segment -> segment.equals(newWall.getPosition()));

        if (!positionOccupied) {
            walls.add(newWall);
        }
    }
}

