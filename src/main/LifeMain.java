package main;

import javax.swing.*;

/**
 * Main class, form which the game is started.
 */
public class LifeMain extends JFrame {

    /**
     * The game's title.
     */
    public static final String TITLE = "That's Life";

    /**
     * Entry point for the game. Sets up main window.
     * @param args command-line arguments
     */
    public static void main (String[] args) {

        JFrame window = new JFrame(TITLE);
        window.setContentPane(new LifePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        // make window appear in the middle of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
