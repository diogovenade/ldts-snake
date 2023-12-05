package viewer.game;

import gui.LanternaGUI;
import model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, LanternaGUI gui);
}
