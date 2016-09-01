package controller;

import model.PowerUp;
import model.map.Map;
import view.MainGameView;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

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
     * Needed for random power-up generation.
     */
    private Random random = new Random();

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
        spawnPowerUps();

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

    /**
     * Randomly spawns a power-up on the map.
     */
    private void spawnPowerUps() {

        double rnd = Math.random();
        random = new Random();

        // 1/1000 chance to get a power-up
        if (rnd < 0.001) {
            int rndX = random.nextInt((map.getMapWidth() - 2) + 1) + 2;
            int rndY = random.nextInt((map.getMapHeight() - 2) + 1) + 2;
            map.getPowerUps().add(new PowerUp("Carbohydrate", rndX, rndY));
        }
    }

    public Map getMap() {
        return map;
    }
}
