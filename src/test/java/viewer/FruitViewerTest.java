package viewer;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.game.elements.Fruit;
import l03gr05.viewer.game.FruitViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class FruitViewerTest {
    private Fruit fruit;
    private FruitViewer fruitViewer;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() {
        fruit = new Fruit(7, 7);
        fruitViewer = new FruitViewer();
        gui = mock(LanternaGUI.class);
    }

    @Test
    public void drawFruit() {
        fruitViewer.draw(fruit, gui);
        verify(gui, times(1)).drawFruit(fruit.getPosition());
    }
}
