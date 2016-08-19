package controller;

import model.PowerUp;
import model.map.Map;
import view.MainGameView;

import java.util.Iterator;

public class MainGameController implements Controller{

    /**
     * Current map. {@link Map}
     */
    private Map map;
    /**
     * Current game view. {@link MainGameView}
     */
    private MainGameView mainGameView;

    /**
     * Sets up model and view.
     * @param mainGameView {@link #mainGameView}
     */
    public MainGameController (MainGameView mainGameView) {
        this.mainGameView = mainGameView;
        map = new Map("src/model/map/default_map.txt");
    }

    /**
     * Alternative controller, only creates new map so view can be added later.
     */
    public MainGameController () {
        map = new Map("src/model/map/default_map.txt");
    }

    @Override
    public void update() {
        updateMap();
    }

    /**
     * Updates all components of the map, e.g. power-ups,
     * enemies and the environment.
     */
    private void updateMap() {
        if (map == null) {
            return;
        }

        updatePowerUps();

        // create power-ups
        int seconds = (int)(System.currentTimeMillis()/1000%60);
        if (seconds%11 == 0) {
            PowerUp powerUp = new PowerUp("Carbohydrate", 7, 7);
            map.getPowerUps().add(powerUp);
        }

    }

    /**
     * Updates all power-ups and removes them from the game
     * when their lifespan has expired.
     */
    private void updatePowerUps() {
        // iterator to avoid concurrent modification on list
        Iterator<PowerUp> iterator = map.getPowerUps().iterator();

        while (iterator.hasNext()) {
            PowerUp powerUp = iterator.next();
            if (powerUp.getCounter() == PowerUp.COUNTER_MAX) {
                iterator.remove();
            } else {
                powerUp.increaseCounter();
            }
        }
    }

    public Map getMap() {
        return map;
    }
}
