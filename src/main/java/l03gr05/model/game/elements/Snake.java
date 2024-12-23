package l03gr05.model.game.elements;

import l03gr05.model.Position;
import l03gr05.model.Direction;

import java.util.LinkedList;


import static l03gr05.model.Direction.*;


public class Snake extends Element {
    private final LinkedList<Position> body = new LinkedList<>();
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

    public Position calculateNewHead() {
        Position head = getSnakeHead();

        if (direction==Up){
            return head.getUp();
        }
        else if(direction==Down){
            return head.getDown();
        }
        else if(direction==Left){
            return head.getLeft();
        }
        else if(direction==Right){
            return head.getRight();
        }
        else{
            throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public void increaseLength() {
        this.length++;
    }

    public void addPosition() {
        this.body.addFirst(new Position(body.getFirst().getX() - 1, body.getFirst().getY()));
    }
}