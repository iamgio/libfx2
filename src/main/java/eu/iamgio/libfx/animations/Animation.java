package eu.iamgio.libfx.animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * @author Gio
 */
public class Animation {

    private Type type;
    private WritableValue<Double> value;
    private double endValue;
    private Duration duration;
    private int cycleCount;

    private Timeline timeline;

    public enum Type {
        MOVEMENT_X, MOVEMENT_Y, MOVEMENT_Z,
        SCALE_X, SCALE_Y, SCALE_Z,
        OPACITY,
        ROTATION
    }

    /**
     * @param type Animation type
     * @param endValue Value to reach
     * @param duration Animation duration
     * @param cycleCount Animation count
     */
    public Animation(Type type, double endValue, Duration duration, int cycleCount) {
        this.type = type;
        this.endValue = endValue;
        this.duration = duration;
        this.cycleCount = cycleCount;
    }

    /**
     * @param type Animation type
     * @param endValue Value to reach
     * @param duration Animation duration
     */
    public Animation(Type type, double endValue, Duration duration) {
        this(type, endValue, duration, 0);
    }

    /**
     * @param property Property
     * @param endValue Value to reach
     * @param duration Animation duration
     * @param cycleCount Animation count
     */
    public Animation(WritableValue<Double> property, double endValue, Duration duration, int cycleCount) {
        this.value = property;
        this.endValue = endValue;
        this.duration = duration;
        this.cycleCount = cycleCount;
    }

    /**
     * @param property Property
     * @param endValue Value to reach
     * @param duration Animation count
     */
    public Animation(WritableValue<Double> property, double endValue, Duration duration) {
        this(property, endValue, duration, 0);
    }

    @SuppressWarnings("unchecked")
    public void play(Node target) {
        timeline = new Timeline();
        timeline.setCycleCount(cycleCount);
        timeline.setAutoReverse(cycleCount > 0);
        WritableValue value = null;
        if(this.value == null && this.type != null) {
            switch(type) {
                case MOVEMENT_X:
                    value = target.translateXProperty();
                    break;
                case MOVEMENT_Y:
                    value = target.translateYProperty();
                    break;
                case MOVEMENT_Z:
                    value = target.translateZProperty();
                    break;
                case SCALE_X:
                    value = target.scaleXProperty();
                    break;
                case SCALE_Y:
                    value = target.scaleYProperty();
                    break;
                case SCALE_Z:
                    value = target.scaleZProperty();
                    break;
                case OPACITY:
                    value = target.opacityProperty();
                    break;
                case ROTATION:
                    value = target.rotateProperty();
                    break;
            }
        }
        else {
            value = this.value;
        }
        assert value != null;
        KeyFrame keyFrame = new KeyFrame(duration, new KeyValue(value, endValue));
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    /**
     * Ends the animation
     */
    public void end() {
        timeline.stop();
    }

    /**
     * Method called when the animation ends
     * @param runnable Runnable to be executed
     */
    public void setOnAnimationCompleted(Runnable runnable) {
        timeline.setOnFinished(e -> runnable.run());
    }
}
