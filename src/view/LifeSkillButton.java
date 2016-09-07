package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

/**
 * Models a button in the skill tree of colonies. A button consists of
 * a base rectangle and a picture drawn over it.
 */
public class LifeSkillButton extends JComponent{

    /**
     * X-coordinate on the map.
     */
    private int xPos;
    /**
     * Y-coordinate on the map.
     */
    private int yPos;
    /**
     * Image which is drawn on the button to display a certain skill.
     */
    private BufferedImage image;
    /**
     * Rectangle as a base for the button.
     */
    private RoundRectangle2D.Double rect;

    /**
     * Initialize components and coordinates.
     * @param image {@link #image}
     * @param xPos {@link #xPos}
     * @param yPos {@link #yPos}
     */
    public LifeSkillButton(BufferedImage image, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.image = image;
        rect = new RoundRectangle2D.Double();
    }

    /**
     * Draws the button itself with all components. First, a rectangle is drawn as a base,
     * then, an image is drawn on top of it to display the skill itself.
     * @param graphics2D graphics to be drawn
     */
    public void draw(Graphics2D graphics2D) {
        if (image == null) {
            return;
        }

        // draw base
        rect.setRoundRect(xPos, yPos, 30, 30, 0, 0);
        graphics2D.draw(rect);
        graphics2D.fill(rect);

        graphics2D.drawImage(image, (int) rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight(), null);
    }

    /**
     * Workaround for click-detection. Measures whether the player clicked on
     * the base rectangle (= the image)
     * @param xPos x-coordinate of the mouse action
     * @param yPos y-coordinate of the mouse action
     * @return click on base rectangle?
     */
    public boolean contains(int xPos, int yPos) {
        return rect.contains(xPos, yPos);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public RoundRectangle2D.Double getRect() {
        return rect;
    }
}
