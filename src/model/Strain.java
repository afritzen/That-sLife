package model;

import model.util.Morphology;

/**
 * Superclass for any bacteria strain that can be chosen in the game.
 * Sets all attributes all bacteria share.
 */
public class Strain {

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
    private String name;
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
     * @param name {@link #name}
     * @param morphology appearance and type {@link #morphology}
     */
    public Strain(String name, Morphology morphology) {
        this.name = name;
        this.morphology = morphology;

        //TODO: compute attributes according to given values
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
