package model.util;

/**
 * Enum for all possible morphologies of bacteria. Here, only the three major types are
 * shown with no regards of any subtypes.
 */
public enum Morphology {

    COCCUS("A sphere-shaped bacterium that can also be arranged in pairs, groups or chains."),
    BACILLUS("A rod-shaped bacterium that is mostly solitary but can be arranged in small chains or side by side."),
    SPIRAL("Spiral-shaped bacterium with various twists per cell and variable cell-thickness.");

    private String description;

    Morphology(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        switch(this) {
            case COCCUS:
                return "Coccus";
            case BACILLUS:
                return "Bacillus";
            case SPIRAL:
                return "Spiral";
        }
        return null;
    }

    public String getDescription() {
        return description;
    }
}
