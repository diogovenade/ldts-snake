package viewer.menu;

import l03gr05.gui.LanternaGUI;
import l03gr05.model.menu.Settings;
import l03gr05.viewer.menu.SettingsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SettingsViewerTest {
    private SettingsViewer settingsViewer;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() {
        settingsViewer = new SettingsViewer(new Settings());
        gui = mock(LanternaGUI.class);
    }

    @Test
    public void testDrawElements() {
        settingsViewer.drawElements(gui);
        verify(gui, times(15)).drawText(any(), any(), any());
    }
}
