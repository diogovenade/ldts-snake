package l03gr05.model.game.elements;

import l03gr05.model.Position;

import java.util.Random;

public class Fruit extends Element {
    public Fruit(int x, int y) {
        super(x, y);
    }

    public void respawn(int maxX, int maxY) {
        Random random = new Random();

        int newX = random.nextInt(maxX);
        int newY = random.nextInt(maxY);

        setPosition(new Position(newX, newY));
    }

}
