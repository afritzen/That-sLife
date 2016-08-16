package model.bacteria;

import model.util.Morphology;
import model.util.StrainName;

/**
 * Subclass for a bacteria strain which occurs in the human body and
 * belongs to the coccus-type.
 */
public class Peptostreptococcus extends Strain{

    /**
     * Shows resistance to a specific antibiotic.
     */
    private String resistence;
    /**
     * Weakness of the strain, e.g. an antibiotic.
     */
    private String weakness;
    /**
     * Risk of becoming pathogenic for the host.
     */
    private int pathogenicRisk;
    /**
     * Determines whether the strain is pathogenic to it's host.
     */
    private boolean pathogenic;

    /**
     * Set specific attributes.
     * @param name {@link #strainName}
     * @param morphology {@link #morphology}
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     */
    public Peptostreptococcus(StrainName name, Morphology morphology, int xPos, int yPos) {
        super(name, morphology, xPos, yPos);
        resistence = "";
        weakness = "beta-lactam";
        pathogenicRisk = 0;
        pathogenic = false;
    }

    public String getResistence() {
        return resistence;
    }

    public void setResistence(String resistence) {
        this.resistence = resistence;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public int getPathogenicRisk() {
        return pathogenicRisk;
    }

    public void setPathogenicRisk(int pathogenicRisk) {
        this.pathogenicRisk = pathogenicRisk;
    }

    public boolean isPathogenic() {
        return pathogenic;
    }

    public void setPathogenic(boolean pathogenic) {
        this.pathogenic = pathogenic;
    }
}
