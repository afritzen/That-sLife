package model.util;

/**
 * Holds all types of power-ups and a brief description.
 */
public enum PowerUpType {

    FATTY_ACID("A valuable source for nutrition."),
    VITAMIN("One of the needed vitamins for the human body."),
    ORGANIC_ACID("Needed for muscle contraction and gaining ATP.");

    /**
     * A short text on what the specific power-up-type is needed for.
     */
    private String info;

    PowerUpType(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        switch (this) {
            case FATTY_ACID:
                return "Fatty acid";
            case VITAMIN:
                return "Vitamin";
            case ORGANIC_ACID:
                return "Organic acid";
        }
        return null;
    }

    public String getInfo() {
        return info;
    }
}
