package model;

/**
 * Mdoels a host for the game in which all strains live.
 */
public class Host {

    /**
     * Overall health of the host (influenced by the vitamin-power-up).
     */
    private int health;
    /**
     * Main activity in the gut. Can decrease during to pathogenic
     * factors or bad living conditions (influenced by the organic-acid-power-up).
     */
    private int gutActivity;
    /**
     * Level of how well minerals like calcium and magnesium are
     * absorbed and utilized (influenced by the fatty-acid-power-up).
     */
    private int mineralHousehold;
    /**
     * Level of nutrition (influenced by the fatty-acid-power-up).
     */
    private int nutritionLevel;
    /**
     * Determines whether the host is dead (= end of game).
     */
    private boolean isDead;

    /**
     * Initialize default attributes.
     */
    public Host () {
        health = 100;
        gutActivity = 50;
        mineralHousehold = 100;
        nutritionLevel = 100;
        isDead = false;
    }

    /**
     * Restores the host's power with a power-up collected from the map.
     * What kind of attribute is powered up is determined by the type of the
     * power-up. Power-ups can also have a negative influence when overused.
     * @param powerUp the collected power-up
     */
    public void givePowerUp(PowerUp powerUp) {

        switch (powerUp.getType()) {

            case FATTY_ACID:
                if (nutritionLevel >= 100) {
                    nutritionLevel = 100;
                } else {
                    nutritionLevel += powerUp.getPower();
                }
                break;
            case ORGANIC_ACID:
                if (gutActivity == 0) {
                    // body no longer functional
                    isDead = true;
                }
                if (gutActivity >= 100) {
                    gutActivity = 100;
                } else {
                    gutActivity += powerUp.getPower();
                }
                break;
            case VITAMIN:
                if (health >= 100) {
                    health = 100;
                } else {
                    health += 100;
                }
                break;
        }

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGutActivity() {
        return gutActivity;
    }

    public void setGutActivity(int gutActivity) {
        this.gutActivity = gutActivity;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getMineralHousehold() {
        return mineralHousehold;
    }

    public void setMineralHousehold(int mineralHousehold) {
        this.mineralHousehold = mineralHousehold;
    }

    public int getNutritionLevel() {
        return nutritionLevel;
    }

    public void setNutritionLevel(int nutritionLevel) {
        this.nutritionLevel = nutritionLevel;
    }
}
