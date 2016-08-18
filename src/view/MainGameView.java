package view;

import main.LifePanel;
import model.map.Map;

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

        for (int row = 0; row < map.getMapHeight(); row++) {
            for (int col = 0; col < map.getMapWidth(); col++) {

                int cellValue = map.getMap()[row][col];
                if (cellValue == 0) {
                    graphics2D.drawImage(spriteFactory.getFrameTileImg(), row*TILE_SIZE, col*TILE_SIZE, null);
                } else if (cellValue == 1) {
                    graphics2D.drawImage(spriteFactory.getBaseTileImg(), row*TILE_SIZE, col*TILE_SIZE, null);
                }
            }
        }
    }
}
