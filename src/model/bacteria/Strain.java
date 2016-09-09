package model.bacteria;

import model.map.Tile;
import model.util.Morphology;
import model.util.Movement;
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
     * Indicates how well the strain is able to analyze other
     * strains or resources to obtain information.
     */
    private int analyzingLevel;
    /**
     * @see model.Colony#ntp
     * Furthermore used for moving on the map.
     */
    private int ntp;
    /**
     * Determines whether the strain has been selected (e.g. for moving).
     */
    private boolean isSelected;

    /**
     * Sets basic attributes according to morphology and name.
     * @param strainName {@link #strainName}
     * @param morphology {@link #morphology}
     */
    public Strain(StrainName strainName, Morphology morphology, int yPos, int xPos) {
        this.strainName = strainName;
        this.morphology = morphology;
        this.xPos = xPos;
        this.yPos = yPos;
        this.analyzingLevel = 1;
        this.ntp = 50;
        this.isSelected = false;
        //TODO: compute attributes according to given values (different for different strains)
    }

    /**
     * Moves the main strain around.
     * @param movement direction of movement
     */
    public void move(Movement movement) {
        switch (movement) {
            case UP:
                yPos -= 1;
                break;
            case DOWN:
                yPos += 1;
                break;
            case LEFT:
                xPos -= 1;
                break;
            case RIGHT:
                xPos += 1;
        }
    }

    /**
     * Moves the strain to a distant target.
     * @param target the target tile
     */
    public void moveBigDistance(Tile target) {
        xPos = target.getxPos();
        yPos = target.getyPos();
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

    public int getAnalyzingLevel() {
        return analyzingLevel;
    }

    public void setAnalyzingLevel(int analyzingLevel) {
        this.analyzingLevel = analyzingLevel;
    }

    public int getNtp() {
        return ntp;
    }

    public void setNtp(int ntp) {
        this.ntp = ntp;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
