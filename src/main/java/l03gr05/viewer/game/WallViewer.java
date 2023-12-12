package l03gr05.viewer.game;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, LanternaGUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
