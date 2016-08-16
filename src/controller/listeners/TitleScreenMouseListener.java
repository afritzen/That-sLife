package controller.listeners;

import controller.LifeEngine;
import controller.MainGameController;
import model.map.Map;
import sun.applet.Main;
import view.MainGameView;
import view.TitleScreenView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Manages all mouse-actions occurring on the title screen.
 */
public class TitleScreenMouseListener implements MouseListener {

    //TODO: make one listener for every view (with lists??)

    private TitleScreenView titleScreenView;
    private LifeEngine lifeEngine;

    public TitleScreenMouseListener (TitleScreenView titleScreenView, LifeEngine lifeEngine) {
        this.titleScreenView = titleScreenView;
        this.lifeEngine = lifeEngine;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (titleScreenView.getStartBtn().contains(e.getX(), e.getY())) {
            MainGameController mainGameController = new MainGameController();
            MainGameView mainGameView = new MainGameView(mainGameController.getMap());
            lifeEngine.setCurrentController(mainGameController);
            lifeEngine.setCurrentView(mainGameView);
        } else if (titleScreenView.getQuitBtn().contains(e.getX(), e.getY())) {
            System.exit(0);
        } else if (titleScreenView.getOptionsBtn().contains(e.getX(), e.getY())) {
            //TODO
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
