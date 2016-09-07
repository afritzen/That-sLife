package model.map;

import model.Colony;
import model.Host;
import model.PowerUp;
import model.bacteria.Peptostreptococcus;
import model.bacteria.Strain;
import model.util.LifeConstants;
import model.util.Morphology;
import model.util.StrainName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents the game's map where the actual gameplay takes place.
 */
public class Map {

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
     * The map as an array of tile objects.
     */
    private Tile[][] tilemap;
    /**
     * Strain the player controls.
     */
    private Strain playerStrain;
    /**
     * All colonies controlled by the player.
     */
    private ArrayList<Colony> playerColonies;
    /**
     * All strains not owned by the player.
     */
    private ArrayList<Strain> otherStrains;
    /**
     * All colonies not owned by the player.
     */
    private ArrayList<Colony> otherColonies;
    /**
     * All carbohydrate-power-ups that are currently on the screen.
     */
    private ArrayList<PowerUp> powerUps;
    /**
     * Host in the game.
     */
    private Host host;

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

        otherStrains = new ArrayList<>();
        playerColonies = new ArrayList<>();
        otherColonies = new ArrayList<>();
        powerUps = new ArrayList<>();
        host = new Host();

        Peptostreptococcus peptostreptococcus = new Peptostreptococcus(
                StrainName.PEPTOSTREPTOCOCCUS, Morphology.COCCUS, 5, 5
        );

        playerStrain = peptostreptococcus;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            // set dimensions
            mapWidth = Integer.parseInt(bufferedReader.readLine());
            mapHeight = Integer.parseInt(bufferedReader.readLine());
            map = new int[mapHeight][mapWidth];
            tilemap = new Tile[mapHeight][mapWidth];

            // read every line and tokens from file
            for (int row = 0; row < mapHeight; row++) {
                String line = bufferedReader.readLine();
                String[] tokens = line.split(LifeConstants.DELIMITER);
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

    public Strain getPlayerStrain() {
        return playerStrain;
    }

    public void setPlayerStrain(Strain playerStrain) {
        this.playerStrain = playerStrain;
    }

    public ArrayList<Strain> getOtherStrains() {
        return otherStrains;
    }

    public ArrayList<Colony> getPlayerColonies() {
        return playerColonies;
    }

    public ArrayList<Colony> getOtherColonies() {
        return otherColonies;
    }

    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    public Host getHost() {
        return host;
    }
}
