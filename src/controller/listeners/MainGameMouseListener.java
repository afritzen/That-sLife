package controller.listeners;

import controller.LifeEngine;
import main.LifePanel;
import model.Colony;
import model.PowerUp;
import model.map.Map;
import model.map.Tile;
import model.util.FieldType;
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
    private Map map;
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
    public MainGameMouseListener(MainGameView mainGameView, Map map, LifeEngine lifeEngine,
                                 LifePanel lifePanel) {
        this.map = map;
        this.mainGameView = mainGameView;
        this.lifeEngine = lifeEngine;
        this.lifePanel = lifePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = e.getY() / MainGameView.TILE_SIZE;
        int col = e.getX() / MainGameView.TILE_SIZE;

        if ((col < map.getMapHeight()) && (row < map.getMapWidth())) {
            Tile currentTile = mainGameView.getTileAt(col, row);
            // select single tile
            if (currentTile != null && (currentTile.getFieldType() != FieldType.FRAME)) {
                if (mainGameView.alreadySelected()) {
                    mainGameView.getCurrentlySelected().setCurrentlySelected(false);
                }

                if (!currentTile.isCurrentlySelected() && (currentTile.getFieldType() != FieldType.FRAME)) {
                    currentTile.setCurrentlySelected(true);
                } else {
                    currentTile.setCurrentlySelected(false);
                }
            }

        }

        // create new colony
        if (mainGameView.getStartColonyBtn().contains(e.getX(), e.getY())) {
            if (!mainGameView.alreadySelected()) {
                return;
            }
            // TODO: check resources!!
            Colony colony = new Colony(map.getPlayerStrain().getStrainName(), mainGameView.getCurrentlySelected().getxPos(),
                    mainGameView.getCurrentlySelected().getyPos());
            map.getPlayerColonies().add(colony);
            mainGameView.setInfoText("Created a new colony!");
        }

        // collect power-up
        if (mainGameView.hasPowerUp(col, row)) {
            PowerUp collected = mainGameView.getPowerUpAt(col, row);
            map.getHost().givePowerUp(collected);
            map.getPowerUps().remove(collected);
            mainGameView.setInfoText("Host gains " + collected.getPower() + " power!");
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
