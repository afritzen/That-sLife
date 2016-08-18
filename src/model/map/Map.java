package model.map;

import model.bacteria.Strain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents the game's map where the actual gameplay takes place.
 */
public class Map {

    /**
     * Separates the tokens read from the map's file.
     */
    public static final String DELIMITER = " ";
    /**
     * Width of the map.
     */
    private int mapWidth;
    /**
     * Height of the map.
     */
    private int mapHeight;
    /**
     * The map itself.
     */
    private int[][] map;
    /**
     * All strains the player owns.
     */
    private ArrayList<Strain> playerStrains;
    /**
     * All strains not owned by the player.
     */
    private ArrayList<Strain> otherStrains;

    /**
     * Set up map.
     */
    public Map (String filename) {
        initMap(filename);
    }

    /**
     * Prototype for map-initialization.
     * @param filename name of the file the map layout is located in
     */
    private void initMap(String filename) {

        playerStrains = new ArrayList<>();
        otherStrains = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            // set dimensions
            mapWidth = Integer.parseInt(bufferedReader.readLine());
            mapHeight = Integer.parseInt(bufferedReader.readLine());
            map = new int[mapHeight][mapWidth];

            // read every line and tokens from file
            for (int row = 0; row < mapHeight; row++) {
                String line = bufferedReader.readLine();
                System.out.println(line);
                String[] tokens = line.split(DELIMITER);
                for (int col = 0; col < mapWidth; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }

        } catch (IOException ioe) {
            System.out.println("Map file not found!");
            ioe.printStackTrace();
        }
    }

    /**
     * Just for testing.
     * TODO: remove later
     */
    public void printMap() {

        if (mapWidth == 0 || mapHeight == 0) {
            System.out.println("map empty");
            return;
        }
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] getMap() {
        return map;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public ArrayList<Strain> getPlayerStrains() {
        return playerStrains;
    }

    public ArrayList<Strain> getOtherStrains() {
        return otherStrains;
    }
}
