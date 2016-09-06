package model;

import model.bacteria.Strain;
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
     * Indicates the competence of absorbing DNA from the environment.
     */
    private int dnaCompetence;
    /**
     * All plasmids the colony has.
     */
    private ArrayList plasmids;

    /**
     * Init basic attributes.
     * @param strainName {@link #strainName}
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     */
    public Colony (StrainName strainName, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.status = 0;
        this.strainName = strainName;
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

    public void setStrainName(StrainName strainName) {
        this.strainName = strainName;
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

    public int getDnaCompetence() {
        return dnaCompetence;
    }

    public void setDnaCompetence(int dnaCompetence) {
        this.dnaCompetence = dnaCompetence;
    }

    public ArrayList getPlasmids() {
        return plasmids;
    }
}


