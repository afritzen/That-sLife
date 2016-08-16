package model.bacteria;

import model.util.Morphology;
import model.util.StrainName;

/**
 * Superclass for any bacteria strain that can be chosen in the game.
 * Sets all attributes all bacteria share.
 */
public class Strain {

    /**
     * X-Position on the game's map.
     */
    private int xPos;
    /**
     * Y-Position on the game's map.
     */
    private int yPos;
    /**
     * Size of the strain's genome.
     */
    private int genomeSize;
    /**
     * Rate of replication when not influenced by any outside-factors.
     */
    private int rateOfReplication;
    /**
     * Time the strain needs for replication.
     */
    private int timeOfReplication;
    /**
     * Size of a single individual bacteria of this strain.
     */
    private int size;
    /**
     * Thickness of cell wall.
     */
    private int thickness;
    /**
     * Rate on which the strain can mutate spontaneously.
     */
    private int mutationRate;
    /**
     * Name of the strain.
     */
    private StrainName strainName;
    /**
     * Appearance and outer form (e.g. round, rod-shaped ...)
     */
    private Morphology morphology;
    /**
     * Determines whether the strain is gram-positive or gram-negative.
     */
    private String gramType;
    /**
     * Determines whether the strain can build spores during difficult
     * environmental circumstances.
     */
    private boolean spores;

    /**
     * Sets basic attributes according to morphology and name.
     * @param strainName {@link #strainName}
     * @param morphology {@link #morphology}
     */
    public Strain(StrainName strainName, Morphology morphology, int xPos, int yPos) {
        this.strainName = strainName;
        this.morphology = morphology;
        this.xPos = xPos;
        this.yPos = yPos;

        //TODO: compute attributes according to given values
    }

    public StrainName getStrainName() {
        return strainName;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getGenomeSize() {
        return genomeSize;
    }

    public int getRateOfReplication() {
        return rateOfReplication;
    }

    public int getTimeOfReplication() {
        return timeOfReplication;
    }

    public int getSize() {
        return size;
    }

    public int getThickness() {
        return thickness;
    }

    public int getMutationRate() {
        return mutationRate;
    }

    public Morphology getMorphology() {
        return morphology;
    }

    public String getGramType() {
        return gramType;
    }

    public boolean hasSpores() {
        return spores;
    }
}
