package viewer.game;

import gui.LanternaGUI;
import model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, LanternaGUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
