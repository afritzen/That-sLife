package main;

import controller.LifeEngine;
import controller.listeners.TitleScreenMouseListener;
import model.map.Map;
import view.TitleScreenView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Panel for the main application. Different screens are drawn here.
 */
public class LifePanel extends JPanel implements Runnable {

    /**
     * Max height of the screen.
     */
    public static final int HEIGHT = 600;
    /**
     * Max width of the screen.
     */
    public static final int WIDTH = 800;
    /**
     * Main game thread.
     */
    private Thread gameThread;
    /**
     * Default white screen.
     */
    private BufferedImage titleScreen;
    /**
     * Used to paint the static title image.
     */
    private Graphics2D graphics2D;
    /**
     * Main graphics.
     */
    private Graphics2D graphics2D2;
    /**
     * Controller initializing the title screen.
     */
    private LifeEngine lifeEngine;
    /**
     * First view in this panel, representing the title screen.
     */
    private TitleScreenView titleScreenView;

    /**
     * Constructor, inherits from JPanel and initializes default
     * settings.
     */
    public LifePanel () {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    /**
     * Sets up new thread as soon as the panel has loaded.
     */
    public void addNotify() {
        super.addNotify();
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    /**
     * Game-loop.
     */
    @Override
    public void run() {

        titleScreen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graphics2D = (Graphics2D)titleScreen.getGraphics();
        graphics2D2 = (Graphics2D) getGraphics();

        long delta = 0;

        // initialize components for first screen
        titleScreenView = new TitleScreenView();
        // TODO: set default controller(?)
        lifeEngine = new LifeEngine(titleScreenView, null);
        addMouseListener(new TitleScreenMouseListener(titleScreenView, lifeEngine));

        Map map = new Map("src/model/map/default_map.txt");
        map.printMap();

        while (true) {

            long lastTime = System.nanoTime();

            lifeEngine.render(graphics2D);
            if (lifeEngine.getCurrentController() != null) {
                lifeEngine.update();
            }

            graphics2D2.drawImage(titleScreen, 0, 0, null);

            delta = System.nanoTime() - lastTime;

            if (delta < 20000000) {
                try {
                    Thread.sleep((20000000 - delta)/1000000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

    }

}
