package model.game.elements;

import model.Position;

import java.util.LinkedList;

public class Snake extends Element {
    private LinkedList<Position> body = new LinkedList<>();

    private int score;

    private byte direction;
    /*
    1 = up
    2 = right
    -1 = down
    -2 = left
    */

    //private Fruit fruit;

    public Snake(int x, int y) {
        super(x, y);
        body.add(new Position(x-2, y));
        body.add(new Position(x-1, y));
        body.add(new Position(x, y));
        this.score = 0;
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

    public byte getDirection() {
        return this.direction;
    }
    public LinkedList<Position> getBody() {return this.body;}

    public void move(){
        int x1 = getSnakeHead().getX();
        int y1 = getSnakeHead().getY();
        Position newpos = new Position(x1,y1);
        if (direction == 2) {newpos = newpos.getRight();}
        else if (direction == -2) {newpos = newpos.getLeft();}
        else if (direction == 1) {newpos = newpos.getUp();}
        else if (direction == -1) {newpos = newpos.getDown();}
        else throw new RuntimeException();
        body.add(newpos);
    }
}
