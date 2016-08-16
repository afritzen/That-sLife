package model.util;

/**
 * Names of all strains that can be played.
 */
public enum StrainName {

    //TODO: add more!

    PEPTOSTREPTOCOCCUS;

    @Override
    public String toString() {
        switch (this) {
            case PEPTOSTREPTOCOCCUS:
                return "Peptostreptococcus";
        }
        return null;
    }
}
