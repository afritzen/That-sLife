package controller;

import view.View;

import java.awt.*;

/**
 * Manages all views and controllers and updates/renders them.
 */
public class LifeEngine {

    /**
     * View that is currently rendered.
     */
    private View currentView;
    /**
     * Controller that is currenly active.
     */
    private Controller currentController;

    /**
     * Initialize view and controller.
     * @param currentView {@link #currentView}
     * @param currentController {@link #currentController}
     */
    public LifeEngine(View currentView, Controller currentController) {
        this.currentView = currentView;
        this.currentController = currentController;
    }

    /**
     * Renders current view's components.
     * @param graphics2D paintbrush
     */
    public void render(Graphics2D graphics2D) {
        currentView.render(graphics2D);
    }

    /**
     * Updates current controller.
     */
    public void update(){currentController.update();}

    public View getCurrentView() {
        return currentView;
    }

    public void setCurrentView(View currentView) {
        this.currentView = currentView;
    }

    public Controller getCurrentController() {
        return currentController;
    }

    public void setCurrentController(Controller currentController) {
        this.currentController = currentController;
    }
}
