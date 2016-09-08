package model;

import model.util.LifeConstants;
import model.util.StrainName;

import java.util.ArrayList;

/**
 * Models a colony the bacteria can form to perform specific tasks.
 * A colony has multiple choices of skills, such as forming a protecting
 * biofilm, absorbing plasmids or performing conjugation with other strains/colonies.
 */
public class Colony {

    /**
     * Strain of the bacteria that is forming the colony.
     */
    private StrainName strainName;
    /**
     * The growth status of the colony (0 = low, 1 = medium, 2 = high).
     */
    private int status;
    /**
     * X-coordinate on the map.
     */
    private int xPos;
    /**
     * Y-coordinate on the map.
     */
    private int yPos;
    /**
     * Determines whether the colony has formed a biofilm.
     */
    private boolean biofilm;
    /**
     * Determines whether the colony is ready for conjugation.
     */
    private boolean conjugation;
    /**
     * Determines whether the colony has imporved it's abitlity to
     * absorb free DNA.
     */
    private boolean dnaCompetence;
    /**
     * Indicates the competence of absorbing DNA from the environment.
     */
    private int dnaCompetenceValue;
    /**
     * All plasmids the colony has.
     */
    private ArrayList plasmids;
    /**
     * Summarizes all kinds of nucleotides, used for gene expression and
     * other skills the colony can have. This is the main currency for building
     * up the colony's skill tree.
     */
    private int ntp;

    /**
     * Init basic attributes.
     * @param strainName {@link #strainName}
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     */
    public Colony (StrainName strainName, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.status = LifeConstants.COLONY_LOW;
        this.strainName = strainName;
        biofilm = false;
        dnaCompetence = false;
        conjugation = false;
        ntp = 50;
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

    public StrainName getStrainName() {
        return strainName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean hasBiofilm() {
        return biofilm;
    }

    public void setBiofilm(boolean biofilm) {
        this.biofilm = biofilm;
    }

    public boolean readyForConjugation() {
        return conjugation;
    }

    public void setConjugation(boolean conjugation) {
        this.conjugation = conjugation;
    }

    public int getDnaCompetenceValue() {
        return dnaCompetenceValue;
    }

    public void setDnaCompetenceValue(int dnaCompetenceValue) {
        this.dnaCompetenceValue = dnaCompetenceValue;
    }

    public boolean hasDnaCompetence() {
        return dnaCompetence;
    }

    public void setDnaCompetence(boolean dnaCompetence) {
        this.dnaCompetence = dnaCompetence;
    }

    public ArrayList getPlasmids() {
        return plasmids;
    }

    public int getNtp() {
        return ntp;
    }

    public void setNtp(int ntp) {
        if (this.ntp >= 100) {
            this.ntp = 100;
        }
        if (this.ntp <= 0) {
            this.ntp = 0;
        }
        this.ntp = ntp;
    }

    /**
     * Returns a string indicating a colony's population.
     * @return the string (low, medium, high)
     */
    public String getDensityByStatus() {
        switch (status) {
            case 0:
                return "low";
            case 1:
                return "medium";
            case 2:
                return "high";
            default:
                return "no information available";
        }
    }
}


