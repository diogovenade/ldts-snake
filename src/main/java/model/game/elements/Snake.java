package model.game.elements;

import model.Position;

import java.util.LinkedList;

public class Snake extends Element {
    private LinkedList<Position> body = new LinkedList<>();

    private int score;

    public Snake(int x, int y) {
        super(x, y);
        body.add(new Position(x, y));
        this.score = 0;
    }

    public Position getSnakeHead() {
        return body.getFirst();
    }

    public void increaseScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }
}
