package viewer.game;

import gui.LanternaGUI;
import model.game.elements.Fruit;

public class FruitViewer implements ElementViewer<Fruit> {
    @Override
    public void draw(Fruit fruit, LanternaGUI gui) {
        gui.drawFruit(fruit.getPosition());
    }
}
