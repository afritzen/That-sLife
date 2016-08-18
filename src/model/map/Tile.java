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
     * Initializes position.
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     * @param type {@link #type}
     */
    public Tile (int xPos, int yPos, int type) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
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
            default:
                fieldType = FieldType.NORMAL;
                break;
        }
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
}
