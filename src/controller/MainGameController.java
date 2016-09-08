package controller;

import model.Colony;
import model.PowerUp;
import model.map.Map;
import model.util.LifeConstants;
import model.util.PowerUpType;
import view.MainGameView;

import java.util.Iterator;
import java.util.Random;

import static model.util.PowerUpType.FATTY_ACID;
import static model.util.PowerUpType.ORGANIC_ACID;
import static model.util.PowerUpType.VITAMIN;

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
        updateColonies();

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
            if (powerUp.getCounter() == LifeConstants.POWER_UP_COUNTER_MAX) {
                iterator.remove();
            } else {
                powerUp.increaseCounter();
            }
        }
    }

    /**
     * Updates all colonies and increases the population density in case
     * they have enough potential to develop. If the minimal conditions are
     * not satisfied, the colony has a certain risk of dying completely.
     */
    private void updateColonies() {

        Iterator<Colony> iterator = map.getPlayerColonies().iterator();
        double rnd = Math.random();

        while (iterator.hasNext()) {
            Colony colony = iterator.next();

            // ntp value needs to be high enough to develop
            if ((colony.getNtp() == 50) && (rnd < 0.00001)) {
                if (colony.getStatus() == LifeConstants.COLONY_HIGH) {
                    // colony has reached highest status
                    continue;
                } else {
                    colony.setStatus(colony.getStatus() + 1);
                }
            }
        }
    }

    /**
     * Randomly spawns a power-up on the map. The different types also have different
     * chances of appearing. Vitamins are the most common type while organic acids can
     * be very rare.
     */
    private void spawnPowerUps() {

        double rnd = Math.random();
        int rndX = random.nextInt((map.getMapWidth() - 2) + 1) + 2;
        int rndY = random.nextInt((map.getMapHeight() - 2) + 1) + 2;

        if (rnd < 0.001) {
            map.getPowerUps().add(new PowerUp(VITAMIN, rndX, rndY));
        } else if (rnd < 0.0001) {
            map.getPowerUps().add(new PowerUp(FATTY_ACID, rndX, rndY));
        } else if (rnd < 0.00001) {
            map.getPowerUps().add(new PowerUp(ORGANIC_ACID, rndX, rndY));
        }
    }

    public Map getMap() {
        return map;
    }
}
