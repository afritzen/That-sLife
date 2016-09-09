package model;

import model.bacteria.Strain;
import model.map.Tile;
import model.util.FieldType;

import java.util.ArrayList;

public class Pathfinder {

    private Strain strain;
    private Tile[][] map;
    private ArrayList<Tile> reachableFields;

    public Pathfinder(Strain strain, Tile[][] map) {
        this.strain = strain;
        this.map = map;
    }

    public void computeReachableFields() {

        ArrayList<Tile> reachableFields = new ArrayList<>();
        int playerNtp = strain.getNtp();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                Tile currentTile = map[row][col];
                if (currentTile.getFieldType() == FieldType.FRAME) {
                    // don't include the map's frame
                    continue;
                }
                if (currentTile.getDistanceToPlayer(strain.getyPos(), strain.getxPos()) < (playerNtp / 2)) {
                    reachableFields.add(currentTile);
                }
            }
        }
        this.reachableFields = reachableFields;
    }

    public ArrayList<Tile> getReachableFields() {
        return reachableFields;
    }
}
