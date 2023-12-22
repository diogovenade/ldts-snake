package l03gr05.model.game.arena;

import l03gr05.model.game.elements.Fruit;
import l03gr05.model.game.elements.Snake;
import l03gr05.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class ClassicArenaBuilder extends ArenaBuilder {
    private final int width;
    private final int height;

    public ClassicArenaBuilder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected Fruit createFruit() {
        return new Fruit(width / 2, height / 2);
    }

    @Override
    protected Snake createSnake() {
        return new Snake(width / 4, height / 2);
    }
    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height));
        }

        for (int y = 1; y < height; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }
}
