package eu.iamgio.libfx.application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author Gio
 */
public class FXStage {

    private Stage stage;
    private FXApplication application;

    FXStage(Stage stage, FXApplication application) {
        this.stage = stage;
        this.application = application;
    }

    /**
     * Sets the scene of the stage
     * @param scene New scene
     * @return this for concatenating
     * @see Stage#setScene(Scene)
     */
    public FXStage withScene(Scene scene) {
        stage.setScene(scene);
        return this;
    }

    /**
     * Sets the resizable value of the stage
     * @param resizable New resizable value
     * @return this for concatenating
     * @see Stage#setResizable(boolean)
     */
    public FXStage resizable(boolean resizable) {
        stage.setResizable(resizable);
        return this;
    }

    /**
     * Sets the icon of the stage
     * @param path Path to the image
     * @return this for concatenating
     */
    public FXStage withIcon(String path) {
        stage.getIcons().add(new Image(application.getClass().getResourceAsStream(path)));
        return this;
    }

    /**
     * Sets the icon of the stage
     * @param image New image
     * @return this for concatenating
     */
    public FXStage withIcon(Image image) {
        stage.getIcons().add(image);
        return this;
    }

    /**
     * Shows the stage
     * @see Stage#show()
     */
    public void show() {
        stage.show();
    }
}
