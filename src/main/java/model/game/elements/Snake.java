package model.game.elements;

import model.Direction;
import model.Position;

import java.util.LinkedList;

import static model.Direction.Right;


public class Snake extends Element {
    private LinkedList<Position> body = new LinkedList<>();
    private int score;
    private Direction direction;
    private int length;

    public Snake(int x, int y) {
        super(x, y);
        body.add(new Position(x-2, y));
        body.add(new Position(x-1, y));
        body.add(new Position(x, y));
        this.score = 0;
        this.direction = Right;
        this.length = 3;
    }

    public Position getSnakeHead() {
        return body.getLast();
    }

    public void increaseScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }

    public LinkedList<Position> getBody() {return this.body;}

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void move() {
        Position newHead = calculateNewHead();
        body.addLast(newHead);

        if (length < body.size()) {
            body.removeFirst();
        }
    }

    private Position calculateNewHead() {
        Position head = getSnakeHead();

        return switch (direction) {
            case Up -> head.getUp();
            case Down -> head.getDown();
            case Left -> head.getLeft();
            case Right -> head.getRight();
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}