package controller.listeners;

import controller.LifeEngine;
import view.TitleScreenView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Manages all mouse-actions occurring on the title screen.
 */
public class TitleScreenMouseListener implements MouseListener {

    private TitleScreenView titleScreenView;
    private LifeEngine lifeEngine;

    public TitleScreenMouseListener (TitleScreenView titleScreenView, LifeEngine lifeEngine) {
        this.titleScreenView = titleScreenView;
        this.lifeEngine = lifeEngine;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (titleScreenView.getStartBtn().contains(e.getX(), e.getY())) {
            System.out.println("game started!");
        } else if (titleScreenView.getQuitBtn().contains(e.getX(), e.getY())) {
            System.out.println("exit");
            System.exit(0);
        } else if (titleScreenView.getOptionsBtn().contains(e.getX(), e.getY())) {
            System.out.println("options");
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
