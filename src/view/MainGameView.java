package view;

import main.LifePanel;
import model.bacteria.Strain;
import model.map.Map;
import model.map.Tile;

import java.awt.*;

/**
 * Renders the game's map and everything inside it. Also provides
 * all needed buttons for user interaction.
 */
public class MainGameView implements View {

    /**
     * Size of one cell.
     */
    public static final int TILE_SIZE = 60;
    /**
     * Map to be drawn. {@link Map}
     */
    private Map map;
    /**
     * The map as an array of tile objects.
     */
    private Tile[][] tilemap;
    /**
     * Provides all images and sprites.
     */
    private SpriteFactory spriteFactory = new SpriteFactory();

    /**
     * Initialize map.
     * @param map {@link Map}
     */
    public MainGameView (Map map) {
        this.map = map;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        // clear screen
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, LifePanel.WIDTH, LifePanel.HEIGHT);

        tilemap = new Tile[map.getMapHeight()][map.getMapWidth()];
        for (int row = 0; row < map.getMapHeight(); row++) {
            for (int col = 0; col < map.getMapWidth(); col++) {

                int cellValue = map.getMap()[row][col];
                // new cell in tile map
                tilemap[row][col] = new Tile(row, col, cellValue);
                // draw images accordingly
                if (cellValue == 0) {
                    graphics2D.drawImage(spriteFactory.getFrameTileImg(), row*TILE_SIZE, col*TILE_SIZE, null);
                } else if (cellValue == 1) {
                    graphics2D.drawImage(spriteFactory.getBaseTileImg(), row*TILE_SIZE, col*TILE_SIZE, null);
                }
            }
        }

        // draw all strains
        for (Strain strain : map.getPlayerStrains()) {
            switch (strain.getStrainName()) {
                case PEPTOSTREPTOCOCCUS:
                    graphics2D.drawImage(spriteFactory.getPeptoImg(), strain.getxPos()*TILE_SIZE, strain.getyPos()*TILE_SIZE, null);
                    break;
                default:
                    // do nothing
                    break;
            }
        }

        drawTimer(graphics2D);
    }

    /**
     * Creates a timer to show up at the upper left corner of the screen.
     * @param graphics2D graphics to be drawn
     */
    private void drawTimer(Graphics2D graphics2D) {
        graphics2D.setFont(new Font("Arial", Font.PLAIN, 20));
        graphics2D.setColor(Color.BLACK);
        int seconds = (int)((System.currentTimeMillis()/1000)%60);
        int minutes = (int) ((System.currentTimeMillis()/(1000*60))%60);
        int hours   = (int) ((System.currentTimeMillis() / (1000*60*60)) % 24);
        graphics2D.drawString(hours + ":" + minutes + ":" + seconds, map.getMapHeight()*TILE_SIZE+20, 30);
    }

    /**
     * Returns the a tile at a desired position.
     * @param xPos x-cccordinate
     * @param yPos y-coordinate
     * @return the tile object
     */
    public Tile getTileAt (int xPos, int yPos) {
        return tilemap[xPos][yPos];
    }
}
