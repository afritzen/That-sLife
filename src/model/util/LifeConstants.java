package model.util;

/**
 * Contains all frequently used constants.
 */
public class LifeConstants {

    /**
     * Width of a common button.
     */
    public static final int BUTTON_WIDTH = 150;
    /**
     * Height of a common button.
     */
    public static final int BUTTON_HEIGHT = 50;
    /**
     * Size of a common button's arc.
     */
    public static final int ARC_SIZE = 10;
    /**
     * Size of a tile on the map.
     */
    public static final int TILE_SIZE = 60;
    /**
     * Delimiter for reading in a map file.
     */
    public static final String DELIMITER = " ";
    /**
     * Lifespan of a power-up (= time it lasts on the map after appearing).
     */
    public static final int POWER_UP_COUNTER_MAX = 200;
    /**
     * Maximum ntp a colony can have.
     */
    public static final int MAX_NTP = 100;
    /**
     * Needed life points for biofilm-skill.
     */
    public static final int BIOFILM_COSTS = 20;
    /**
     * Needed life points for competence-skill.
     */
    public static final int COMPETENCE_COSTS = 15;
    /**
     * Needed life points for conjugation-skill.
     */
    public static final int CONJUGATION_COSTS = 10;

    /**
     * Private constructor, should not be called since it's not
     * necessary.
     */
    private LifeConstants() {
        throw new AssertionError();
    }
}
