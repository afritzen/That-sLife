package view;

import main.LifePanel;
import model.util.LifeConstants;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Renders the title screen with all buttons and the title image.
 */
public class TitleScreenView implements View{

    /**
     * Button for starting the game.
     */
    private RoundRectangle2D startBtn = new RoundRectangle2D.Double();
    /**
     * Button for quitting the game.
     */
    private RoundRectangle2D.Double quitBtn = new RoundRectangle2D.Double();
    /**
     * Button for settings.
     */
    private RoundRectangle2D optionsBtn = new RoundRectangle2D.Double();
    /**
     * All buttons to loop over.
     */
    private RoundRectangle2D[] buttons = {startBtn, optionsBtn, quitBtn};
    /**
     * All button-texts to loop over.
     */
    private String[] selection = {"Start", "Options", "Quit"};
    private Font titleFont;
    private Font standardFont;

    /**
     * Not needed.
     */
    public TitleScreenView () {

    }

    /**
     * Renders all compoents and fills the screen with a background.
     * @param graphics2D paintbrush
     */
    @Override
    public void render (Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, LifePanel.WIDTH, LifePanel.HEIGHT);
        titleFont = new Font("Century Gothic", Font.ITALIC, 90);
        graphics2D.setFont(titleFont);
        graphics2D.setColor(Color.CYAN);
        graphics2D.drawString("That's Life", 200, 150);
        drawButtons(graphics2D);
        drawOptions(graphics2D);
    }


    /**
     * Loops through all buttons and renders them.
     * @param graphics2D paintbrush
     */
    public void drawButtons(Graphics2D graphics2D) {
        graphics2D.setColor(Color.CYAN);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setRoundRect(300, 150+100*(i+1),
                    LifeConstants.BUTTON_WIDTH, LifeConstants.BUTTON_HEIGHT, LifeConstants.ARC_SIZE, LifeConstants.ARC_SIZE);
            graphics2D.draw(buttons[i]);
            graphics2D.fill(buttons[i]);
        }
    }

    /**
     * Loops through all button-texts and renders them.
     * @param graphics2D paintbrush
     */
    public void drawOptions(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        standardFont = new Font("Arial", Font.PLAIN, 15);
        graphics2D.setFont(standardFont);
        for (int i = 0; i < selection.length; i++) {
            graphics2D.drawString(selection[i], 350, 180+100*(i+1));
        }
    }

    public RoundRectangle2D getStartBtn() {
        return startBtn;
    }

    public RoundRectangle2D getQuitBtn() {
        return quitBtn;
    }

    public RoundRectangle2D getOptionsBtn() {
        return optionsBtn;
    }
}
