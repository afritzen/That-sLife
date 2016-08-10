package main;

import controller.TitleScreenController;
import controller.listeners.TitleScreenMouseListener;
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
    private TitleScreenController titleScreenController;
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
        addMouseListener(new TitleScreenMouseListener(this));
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

        while (true) {

            long lastTime = System.nanoTime();

            // paint screen black
            graphics2D.setColor(Color.BLACK);
            graphics2D.fillRect(0, 0, WIDTH, HEIGHT);

            // initialize components for first screen
            titleScreenView = new TitleScreenView();
            titleScreenController = new TitleScreenController(titleScreenView);
            titleScreenController.render(graphics2D);

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
