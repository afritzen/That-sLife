package controller.listeners;

import main.LifePanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Manages all mouse-actions occurring on the title screen.
 */
public class TitleScreenMouseListener implements MouseListener {

    /**
     * Panel containing the game's current components.
     */
    private LifePanel lifePanel;

    public TitleScreenMouseListener (LifePanel lifePanel) {
        this.lifePanel = lifePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
