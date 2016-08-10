package controller;

import view.TitleScreenView;
import java.awt.*;

public class TitleScreenController {

    private TitleScreenView titleScreenView;

    public TitleScreenController (TitleScreenView titleScreenView) {
        this.titleScreenView = titleScreenView;
    }

    public void render(Graphics2D graphics2D) {
        titleScreenView.render(graphics2D);
    }

}
