package controller.listeners;

import controller.LifeEngine;
import main.LifePanel;
import view.MainGameView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Manages all mouse events occurring on the main screen (map and buttons).
 */
public class MainGameMouseListener implements MouseListener{

    /**
     * {@link MainGameView}
     */
    private MainGameView mainGameView;
    /**
     * {@link LifeEngine}
     */
    private LifeEngine lifeEngine;
    /**
     * {@link LifePanel}
     */
    private LifePanel lifePanel;

    /**
     * Initialize components.
     * @param mainGameView
     * @param lifeEngine
     * @param lifePanel
     */
    public MainGameMouseListener(MainGameView mainGameView, LifeEngine lifeEngine,
                                 LifePanel lifePanel) {
        this.mainGameView = mainGameView;
        this.lifeEngine = lifeEngine;
        this.lifePanel = lifePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //TODO: remove, just a test
        System.out.println(mainGameView.getTileAt(e.getX()/mainGameView.TILE_SIZE, e.getY()/mainGameView.TILE_SIZE).getFieldType());
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
