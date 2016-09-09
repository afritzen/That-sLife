package controller.listeners;

import controller.LifeEngine;
import main.LifePanel;
import model.Colony;
import model.Pathfinder;
import model.PowerUp;
import model.bacteria.Strain;
import model.map.Map;
import model.map.Tile;
import model.util.FieldType;
import model.util.LifeConstants;
import model.util.Movement;
import view.MainGameView;
import view.SpriteFactory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
     * Searches for all reachable fields for the player's main strain.
     */
    private Pathfinder pathfinder;

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
        this.pathfinder = new Pathfinder(map.getPlayerStrain(), mainGameView.getTilemap());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = e.getY() / LifeConstants.TILE_SIZE;
        int col = e.getX() / LifeConstants.TILE_SIZE;

        Strain playerStrain = map.getPlayerStrain();
        ArrayList<Tile> toHighlight = mainGameView.getToHighlight();

        if (!playerStrain.isSelected()) {
            // delete all former selections
            toHighlight.clear();
        } else {
            if (toHighlight.contains(mainGameView.getTileAt(row, col))) {
                // move player's main strain
                playerStrain.moveBigDistance(mainGameView.getTileAt(row,col));
                pathfinder.getReachableFields().clear();
                toHighlight.clear();
                playerStrain.setSelected(false);
            } else {
                pathfinder.getReachableFields().clear();
                toHighlight.clear();
                playerStrain.setSelected(false);
               // return;
            }
        }

        if ((col < map.getMapHeight()) && (row < map.getMapWidth())) {
            Tile currentTile = mainGameView.getTileAt(row, col);
            // select single tile
            if (currentTile != null && (currentTile.getFieldType() != FieldType.FRAME)) {
                if (mainGameView.alreadySelected()) {
                    mainGameView.getCurrentlySelected().setCurrentlySelected(false);
                    playerStrain.setSelected(false);
                }

                if (!currentTile.isCurrentlySelected() && (currentTile.getFieldType() != FieldType.FRAME)) {

                    if (mainGameView.hasPlayerStrain(row, col)) {
                        if (toHighlight.isEmpty()) {
                            playerStrain.setSelected(true);
                            pathfinder.computeReachableFields();
                            mainGameView.addReachableFields(pathfinder.getReachableFields());
                        }

                    }

                    currentTile.setCurrentlySelected(true);

                } else {
                    currentTile.setCurrentlySelected(false);
                    playerStrain.setSelected(false);
                }
            }

        }

        // create new colony
        if (mainGameView.getStartColonyBtn().contains(e.getX(), e.getY())) {
            if (!mainGameView.alreadySelected()) {
                return;
            }

            Colony colony = new Colony(map.getPlayerStrain().getStrainName(), mainGameView.getCurrentlySelected().getyPos(),
                        mainGameView.getCurrentlySelected().getxPos());
            map.getPlayerColonies().add(colony);
            mainGameView.setInfoText("Created a new colony!");
        }

        int currX = mainGameView.getCurrentlySelected().getxPos();
        int currY = mainGameView.getCurrentlySelected().getyPos();
        Colony colony;

        if (!mainGameView.hasColony(currY, currX)) {
            return;
        } else {
            colony = mainGameView.getColonyAt(currY, currX);
        }

        if (mainGameView.getBiofilmSkillBtn().contains(e.getX(), e.getY())) {

            if (colony.hasBiofilm()) {
                return;
            }

            if (colony.getNtp() >= LifeConstants.BIOFILM_COSTS) {
                colony.setNtp(colony.getNtp() - LifeConstants.BIOFILM_COSTS);
                colony.setBiofilm(true);
            }
        }

        if (mainGameView.getCompetenceSkillBtn().contains(e.getX(), e.getY())) {

            if (colony.hasDnaCompetence()) {
                return;
            }

            if (colony.getNtp() >= LifeConstants.COMPETENCE_COSTS) {
                colony.setNtp(colony.getNtp() - LifeConstants.COMPETENCE_COSTS);
                colony.setDnaCompetence(true);
            }
        }

        if (mainGameView.getConjugationSkillBtn().contains(e.getX(), e.getY())) {

            if (colony.readyForConjugation()) {
                return;
            }

            if (colony.getNtp() >= LifeConstants.CONJUGATION_COSTS) {
                colony.setNtp(colony.getNtp() - LifeConstants.CONJUGATION_COSTS);
                colony.setConjugation(true);
            }
        }

        // collect power-up
        if (mainGameView.hasPowerUp(row, col)) {
            PowerUp collected = mainGameView.getPowerUpAt(row, col);
            map.getHost().givePowerUp(collected);
            map.getPowerUps().remove(collected);
            mainGameView.setInfoText("Host gains " + collected.getPower() + " power!");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // generated method stub
    }

}
