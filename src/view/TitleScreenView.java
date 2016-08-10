package view;

import main.LifePanel;

import java.awt.*;

public class TitleScreenView {

    public TitleScreenView () {}

    public void render (Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(0, 0, LifePanel.WIDTH, LifePanel.HEIGHT);
        graphics2D.setFont(new Font("Arial", Font.PLAIN, 15));
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString("HELLO WORLD", 400, 400);
    }

}
