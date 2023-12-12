package l03gr05.model.game.arena;

import l03gr05.model.game.elements.Fruit;
import l03gr05.model.game.elements.Snake;
import l03gr05.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setSnake(createSnake());
        arena.setFruit(createFruit());
        arena.setWalls(createWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract Fruit createFruit();

    protected abstract Snake createSnake();
}
