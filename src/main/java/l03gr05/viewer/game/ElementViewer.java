package l03gr05.viewer.game;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, LanternaGUI gui);
}
