package eu.iamgio.libfx.timing;

import javafx.util.Duration;

/**
 * Class extended by different timer types
 * @author Gio
 */
public abstract class Timer {

    protected boolean ended;
    protected java.util.Timer timer = new java.util.Timer();

    /**
     * Starts the timer
     * @param task Task to be executed
     * @param duration Timer duration
     */
    public abstract void start(Runnable task, Duration duration);

    /**
     * @return Getter for property {@link #ended}
     */
    public boolean isEnded() {
        return ended;
    }

    /**
     * Ends the timer
     */
    public abstract void end();
}
