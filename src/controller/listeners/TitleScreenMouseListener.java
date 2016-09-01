package controller.listeners;

import controller.LifeEngine;
import controller.MainGameController;
import main.LifePanel;
import view.MainGameView;
import view.TitleScreenView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Manages all mouse-actions occurring on the title screen.
 */
public class TitleScreenMouseListener implements MouseListener {

    /**
     * {@link TitleScreenView}
     */
    private TitleScreenView titleScreenView;
    /**
     * {@link LifeEngine}
     */
    private LifeEngine lifeEngine;
    /**
     * {@link LifePanel}
     */
    private LifePanel lifePanel;

    /**
     * Initialize all components.
     * @param titleScreenView
     * @param lifeEngine
     * @param lifePanel
     */
    public TitleScreenMouseListener (TitleScreenView titleScreenView, LifeEngine lifeEngine,
                                     LifePanel lifePanel) {
        this.titleScreenView = titleScreenView;
        this.lifeEngine = lifeEngine;
        this.lifePanel = lifePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (titleScreenView.getStartBtn().contains(e.getX(), e.getY())) {

            // start button clicked, initialize new view and controller for main game ...
            MainGameController mainGameController = new MainGameController();
            MainGameView mainGameView = new MainGameView(mainGameController.getMap());
            lifeEngine.setCurrentController(mainGameController);
            lifeEngine.setCurrentView(mainGameView);
            lifePanel.addMouseListener(new MainGameMouseListener(mainGameView, mainGameController.getMap(),
                    lifeEngine, lifePanel));

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
