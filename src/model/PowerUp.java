package model;

/**
 * Models a power-up in the game which can be used to improve the
 * host's health or change/set attributes of the player's strain.
 */
public class PowerUp {

    /**
     * Maximum amount of time a power-up stays
     * on the map.
     */
    public static final int COUNTER_MAX = 500;
    /**
     * Type of the power-up (e.g. carbohydrate).
     */
    private String type;
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
     * @param type {@link #type}
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     */
    public PowerUp(String type, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        switch (type) {
            case "Carbohydrate":
                power = 10;
                counter = 0;
                break;
            default:
                power = 0;
                counter = 0;
                break;
        }
    }

    public void increaseCounter() {
        counter+= 1;
    }

    public String getType() {
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
