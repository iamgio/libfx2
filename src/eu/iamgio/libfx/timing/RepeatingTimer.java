package eu.iamgio.libfx.timing;

import javafx.util.Duration;

import java.util.TimerTask;

/**
 * Task that executes a task reapeatedly
 * @author Gio
 */
public class RepeatingTimer extends Timer {

    private WaitingTimer timer = new WaitingTimer();

    @Override
    public void start(Runnable task, Duration duration) {
        if(!isEnded()) {
            task.run();
            timer.start(new TimerTask() {
                @Override
                public void run() {
                    start(task, duration);
                }
            }, duration);
        }
    }

    @Override
    public void end() {
        ended = true;
        try {
            timer.end();
        } catch(IllegalStateException e) {
            //Empty catch block
        }
    }
}
