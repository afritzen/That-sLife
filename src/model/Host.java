package model;

/**
 * Mdoels a host for the game in which all strains live.
 */
public class Host {

    private int health;
    private int gutActivity;
    private boolean isDead;

    /**
     * Initialize default attributes.
     */
    public Host () {
        health = 100;
        gutActivity = 100;
        isDead = false;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGutActivity() {
        return gutActivity;
    }

    public void setGutActivity(int gutActivity) {
        this.gutActivity = gutActivity;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
