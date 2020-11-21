package eu.iamgio.libfx.timing;

import eu.iamgio.libfx.exceptions.FXRuntimeException;
import javafx.animation.AnimationTimer;

/**
 * @author Gio
 */
public class Rendering {

    private AnimationTimer timer;

    /**
     * Method called on every rendering
     * @param runnable Runnable to be executed
     */
    public void onRender(Runnable runnable) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                runnable.run();
            }
        };
        timer.start();
    }

    /**
     * Stops the loop
     */
    public void stop() {
        if(timer == null) throw new FXRuntimeException("The loop is not running");
        timer.stop();
    }
}
