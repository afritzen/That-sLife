package view;

import main.LifePanel;
import model.Colony;
import model.Host;
import model.PowerUp;
import model.bacteria.Strain;
import model.map.Map;
import model.map.Tile;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

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
     * Host whose info is displayed (e.g. in HUD).
     */
    private Host host;
    /**
     * The map as an array of tile objects.
     */
    private Tile[][] tilemap;
    /**
     * Provides all images and sprites.
     */
    private SpriteFactory spriteFactory = new SpriteFactory();
    /**
     * Small text showing information about collecting a power-up or critical host-condition.
     */
    private String infoText = "";
    private RoundRectangle2D.Double startColonyBtn = new RoundRectangle2D.Double();

    /**
     * Initialize map.
     * @param map {@link Map}
     */
    public MainGameView (Map map) {
        this.map = map;
        this.host = map.getHost();
        initTilemap();
    }

    @Override
    public void render(Graphics2D graphics2D) {

        // clear screen
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, LifePanel.WIDTH, LifePanel.HEIGHT);

        //draw all tiles
        for (int row = 0; row < map.getMapHeight(); row++) {
            for (int col = 0; col < map.getMapWidth(); col++) {

                Tile currentTile = tilemap[row][col];
                int currentTileX = currentTile.getxPos() * TILE_SIZE;
                int currentTileY = currentTile.getyPos() * TILE_SIZE;

                switch (currentTile.getFieldType()) {
                    case FRAME:
                        graphics2D.drawImage(spriteFactory.getFrameTileImg(), currentTileX, currentTileY, null);
                        break;
                    case NORMAL:
                        graphics2D.drawImage(spriteFactory.getBaseTileImg(), currentTileX, currentTileY, null);
                        break;
                   }

            }
        }

        // draw player strain
        Strain playerStrain = map.getPlayerStrain();
        switch (playerStrain.getStrainName()) {
            case PEPTOSTREPTOCOCCUS:
                graphics2D.drawImage(spriteFactory.getPeptoImg(), playerStrain.getxPos()*TILE_SIZE, playerStrain.getyPos()*TILE_SIZE, null);
                break;
            default:
                // do nothing
                break;
        }

        // draw player colonies
        for (Colony colony : map.getPlayerColonies()) {
            switch (colony.getStatus()) {
                case 0:
                    graphics2D.drawImage(spriteFactory.getColonyLowImg(), colony.getxPos() * TILE_SIZE, colony.getyPos() * TILE_SIZE, null);
                    break;
                case 1:
                    graphics2D.drawImage(spriteFactory.getColonyMediumImg(), colony.getxPos() * TILE_SIZE, colony.getyPos() * TILE_SIZE, null);
                    break;
                case 2:
                    graphics2D.drawImage(spriteFactory.getColonyHighImg(), colony.getxPos() * TILE_SIZE, colony.getyPos() * TILE_SIZE, null);
                    break;
            }
        }

        // draw all power-ups
        for (PowerUp powerUp : map.getPowerUps()) {
            graphics2D.drawImage(spriteFactory.getCarbImg(), powerUp.getxPos()*TILE_SIZE + 15, powerUp.getyPos()*TILE_SIZE + 15, null);
        }

        drawSelection(graphics2D);
        drawTimer(graphics2D);
        drawHUD(graphics2D);

        // button just for testing, to be removed later!
        graphics2D.setColor(Color.PINK);
        startColonyBtn.setRoundRect(map.getMapHeight() * TILE_SIZE + 20, 250, 150, 50, 10, 10);
        graphics2D.draw(startColonyBtn);
        graphics2D.fill(startColonyBtn);

    }

    /**
     * Set up tilemap, create tiles and their attributes.
     */
    private void initTilemap() {

        tilemap = new Tile[map.getMapHeight()][map.getMapWidth()];
        for (int row = 0; row < map.getMapHeight(); row++) {
            for (int col = 0; col < map.getMapWidth(); col++) {

                int cellValue = map.getMap()[row][col];
                tilemap[row][col] = new Tile(row, col, cellValue);

                // create new preset colony for the player
                if (cellValue == 2) {
                    Colony colony = new Colony(map.getPlayerStrain().getStrainName(), row, col);
                    map.getPlayerColonies().add(colony);
                }
            }
        }
    }

    /**
     * Draws a highlight around the currently selected field(s).
     * @param graphics2D graphics to be drawn
     */
    private void drawSelection(Graphics2D graphics2D) {
        for (int row = 0; row < map.getMapHeight(); row++) {
            for (int col = 0; col < map.getMapWidth(); col++) {
                Tile currentTile = tilemap[row][col];
                if (currentTile.isCurrentlySelected()) {
                    graphics2D.drawImage(spriteFactory.getSlectionImg(), currentTile.getxPos() * TILE_SIZE,
                            currentTile.getyPos() * TILE_SIZE, null);
                }
            }
        }
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
        graphics2D.drawString(hours + ":" + minutes + ":" + seconds, map.getMapHeight() * TILE_SIZE + 20, 30);
    }

    /**
     * Draws a basic HUD, to be improved later!
     * @param graphics2D graphics to be drawn
     */
    private void drawHUD (Graphics2D graphics2D) {

        graphics2D.drawString("Health: " + host.getHealth(), map.getMapHeight() * TILE_SIZE + 20, 70);
        graphics2D.drawString("Nutrition Level: " + host.getNutritionLevel(), map.getMapHeight() * TILE_SIZE + 20, 110);
        graphics2D.drawString("Gut activity: " + host.getGutActivity(), map.getMapHeight() * TILE_SIZE + 20, 150);
        graphics2D.drawString("Mineral household: " + host.getMineralHousehold(), map.getMapHeight() * TILE_SIZE + 20, 190);
        graphics2D.drawString(infoText, map.getMapHeight() * TILE_SIZE + 20, 230);
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

    /**
     * Returns the power-up at a specific place.
     * @param xPos x-coordinate on the map
     * @param yPos y-coordinate on the map
     * @return the power-up
     */
    public PowerUp getPowerUpAt(int xPos, int yPos) {
        for (PowerUp powerUp : map.getPowerUps()) {
            if (powerUp.getxPos() == xPos && powerUp.getyPos() == yPos) {
                return powerUp;
            }
        }
        return null;
    }

    /**
     * Returns the colony at a specific point.
     * @param xPos x-coordinate on the map
     * @param yPos y-coordinate on the map
     * @return the colony
     */
    public Colony getColonyAt (int xPos, int yPos) {
        for (Colony colony : map.getPlayerColonies()) {
            if (colony.getxPos() == xPos && colony.getyPos() == yPos) {
                return colony;
            }
        }
        return null;
    }

    /**
     * Determines whether a specific field has a power-up on it.
     * @param xPos x-coordinate of the field
     * @param yPos y-coordinate of the field
     * @return field has power-up?
     */
    public boolean hasPowerUp(int xPos, int yPos) {
        for (PowerUp powerUp : map.getPowerUps()) {
            if ((powerUp.getxPos() == xPos) && (powerUp.getyPos() == yPos)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there is already a selected tile on the map.
     * @return tile already selected?
     */
    public boolean alreadySelected() {
        for (int row = 0; row < map.getMapHeight(); row++) {
            for (int col = 0; col < map.getMapWidth(); col++) {
                if (tilemap[row][col].isCurrentlySelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the currently selected tile.
     * @return see above
     */
    public Tile getCurrentlySelected() {
        for (int row = 0; row < map.getMapHeight(); row++) {
            for (int col = 0; col < map.getMapWidth(); col++) {
                if (tilemap[row][col].isCurrentlySelected()) {
                    return tilemap[row][col];
                }
            }
        }
        return null;
    }

    public RoundRectangle2D.Double getStartColonyBtn() {
        return startColonyBtn;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public Tile[][] getTilemap() {
        return tilemap;
    }

    public Map getMap() {
        return map;
    }
}
