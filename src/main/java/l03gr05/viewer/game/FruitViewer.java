package l03gr05.viewer.game;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.game.elements.Fruit;

public class FruitViewer implements ElementViewer<Fruit> {
    @Override
    public void draw(Fruit fruit, LanternaGUI gui) {
        gui.drawFruit(fruit.getPosition());
    }
}
