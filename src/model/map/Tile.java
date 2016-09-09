package model.map;

import model.util.FieldType;

/**
 * Models a single tile of the game's map.
 */
public class Tile {

    /**
     * Type of the tile, e.g. resource, etc.
     */
    private int type;
    private FieldType fieldType;
    /**
     * X-coordinate on the map.
     */
    private int xPos;
    /**
     * Y-coordinate on the map.
     */
    private int yPos;
    /**
     * Determines whether the tile has been selected by the player.
     */
    private boolean currentlySelected;

    /**
     * Initializes position.
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     * @param type {@link #type}
     */
    public Tile (int yPos, int xPos, int type) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
        currentlySelected = false;
        computeFieldType();
    }

    /**
     * Computes the actual type of the field according to given value from
     * the map's file.
     */
    private void computeFieldType () {
        switch (type) {
            case 0:
                fieldType = FieldType.FRAME;
                break;
            case 1:
                fieldType = FieldType.NORMAL;
                break;
           }
    }

    /**
     * Computes the distance from the tile to the player's
     * main strain.
     * @param playerXpos x-coordinate of the player
     * @param playerYpos y-coordinate of the player
     * @return distance between player and tile
     */
    public int getDistanceToPlayer(int playerYpos, int playerXpos) {

        int dist;

        if ((playerXpos != xPos) && (playerYpos != yPos)) {
            // field not reachable
            return Integer.MAX_VALUE;
        }

        if (playerXpos != xPos) {
            // y-distance has to be computed
            dist = xPos - playerXpos;
            if (dist < 0) {
                return dist * (-1);
            } else {
                return dist;
            }
        }

        if (playerYpos != yPos) {
            // x-distance has to be computed
            dist = yPos - playerYpos;
            if (dist < 0) {
                return dist * (-1);
            } else {
                return dist;
            }
        }

        // just to be sure ...
        return Integer.MAX_VALUE;
    }

    public int getType() {
        return type;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setType(int type) {
        this.type = type;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isCurrentlySelected() {
        return currentlySelected;
    }

    public void setCurrentlySelected(boolean currentlySelected) {
        this.currentlySelected = currentlySelected;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
