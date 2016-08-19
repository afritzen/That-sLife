package view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Loads all images and sprites at runtime.
 */
public class SpriteFactory {


    /**
     * A basic tile of the game's map.
     */
    private BufferedImage baseTileImg = loadImage("/resources/tiles/base_tile_big.png");
    /**
     * A tile for the outer frame of the game's map.
     */
    private BufferedImage frameTileImg = loadImage("/resources/tiles/frame_tile_big.png");
    /**
     * Image for the Peptostreptococcus strain.
     */
    private BufferedImage peptoImg = loadImage("/resources/bacteria/pepto_sprite.png");
    /**
     * Image for a carbohydrate power-up.
     */
    private BufferedImage carbImg = loadImage("/resources/carb_sprite.png");

    /**
     * Default constructor, not needed.
     */
    public SpriteFactory(){}

    /**
     * Loads a single image, e.g. a tile or an item.
     * @param filename name of the file that holds the image
     * @return the image used by a view to render
     */
    public BufferedImage loadImage (String filename) {
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResourceAsStream(filename));
            return bufferedImage;
        } catch (IOException ioe) {
            System.out.println("image not found!");
            ioe.printStackTrace();
        }
          return null;
    }

    public BufferedImage getBaseTileImg() {
        return baseTileImg;
    }

    public BufferedImage getFrameTileImg() {
        return frameTileImg;
    }

    public BufferedImage getPeptoImg() {
        return peptoImg;
    }

    public BufferedImage getCarbImg() {
        return carbImg;
    }
}
