package l03gr05.model.menu;

import java.util.List;

public class MenuModel {
    protected int selectedEntry = 0;
    protected boolean running;
    protected List<String> entries;
    protected int score;
    public MenuModel() {
        this.running = true;
    }

    public void nextEntry() {
        selectedEntry++;
        if (selectedEntry > entries.size() - 1)
            selectedEntry = 0;
    }
    public void previousEntry() {
        selectedEntry--;
        if (selectedEntry < 0)
            selectedEntry = entries.size() - 1;
    }
    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getNumberEntries() {
        return entries.size();
    }
    public boolean isSelected(int i) {
        return selectedEntry == i;
    }

    public int getScore(){
        return this.score;
    }
}
