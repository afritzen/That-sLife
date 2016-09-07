package model;

import model.util.PowerUpType;

/**
 * Models a power-up in the game which can be used to improve the
 * host's health or change/set attributes of the player's strain.
 */
public class PowerUp {

    /**
     * Type of the power-up (e.g. carbohydrate).
     */
    private PowerUpType type;
    /**
     * X-coordinate on the map.
     */
    private int xPos;
    /**
     * Y-coordinate on the map.
     */
    private int yPos;
    /**
     * Value of the power-up.
     */
    private int power;
    /**
     * Determines how long the power-up will stay
     * on the map until it disappears.
     */
    private long counter;

    /**
     * Sets attributes according to type.
     *
     * @param type {@link #type}
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     */
    public PowerUp(PowerUpType type, int xPos, int yPos) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;

        switch (type) {
            case FATTY_ACID:
                power = 10;
                counter = 0;
                break;
            case ORGANIC_ACID:
                power = 5;
                counter = 0;
                break;
            case VITAMIN:
                power = 15;
                counter = 0;
                break;
            default:
                power = 0;
                counter = 0;
                break;
        }
    }

    public void increaseCounter() {
        counter += 1;
    }

    public PowerUpType getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public long getCounter() {
        return counter;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
