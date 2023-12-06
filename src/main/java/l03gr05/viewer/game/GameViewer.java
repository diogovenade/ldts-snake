package l03gr05.viewer.game;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.Position;
import l03gr05.model.game.arena.Arena;
import l03gr05.model.game.elements.Element;
import l03gr05.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        drawElement(gui, getModel().getSnake(), new SnakeViewer());
        drawElement(gui, getModel().getFruit(), new FruitViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());

        gui.drawText(new Position(5, 5), "Score: " + getModel().getSnake().getScore(), "#04EC0B");
    }

    private <T extends Element> void drawElements(LanternaGUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(LanternaGUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
