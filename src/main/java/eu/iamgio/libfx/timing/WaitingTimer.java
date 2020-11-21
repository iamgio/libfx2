package eu.iamgio.libfx.timing;
import javafx.util.Duration;

import java.util.TimerTask;

/**
 * Timer that executes a task after a delay
 * @author Gio
 */
public class WaitingTimer extends Timer {

    @Override
    public void start(Runnable task, Duration duration) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, (long) duration.toMillis());
    }

    @Override
    public void end() {
        ended = true;
        try {
            timer.cancel();
        } catch(IllegalStateException e) {
            //Empty catch block
        }
    }
}
