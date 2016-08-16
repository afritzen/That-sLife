package controller;

import model.map.Map;
import view.MainGameView;

public class MainGameController implements Controller{

    /**
     * Current map. {@link Map}
     */
    private Map map;
    /**
     * Current game view. {@link MainGameView}
     */
    private MainGameView mainGameView;

    public MainGameController (MainGameView mainGameView) {
        this.mainGameView = mainGameView;
        map = new Map("src/model/map/default_map.txt");
    }

    public MainGameController () {
        map = new Map("src/model/map/default_map.txt");
    }

    @Override
    public void update() {
        // TODO
    }

    public Map getMap() {
        return map;
    }
}
