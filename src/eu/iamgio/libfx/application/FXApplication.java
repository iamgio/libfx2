package eu.iamgio.libfx.application;

import eu.iamgio.libfx.exceptions.FXException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class that must be extended by main class in a JavaFX application
 * @author Gio
 */
public abstract class FXApplication extends Application {

    private FXStage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = new FXStage(primaryStage, this);
        start();
    }

    /**
     * Method called when the application is launched
     * @throws Exception If an {@link Exception} is cought
     */
    public abstract void start() throws Exception;

    /**
     * Loads a FXML file
     * @param path Path to the .fxml file
     * @return FXML as {@link Pane}
     * @throws FXException If the file cannot be loaded
     */
    public Pane loadRoot(String path) throws FXException {
        try {
            return FXMLLoader.load(getClass().getResource(path));
        }
        catch(IOException e) {
            throw new FXException("Cannot load FXML from " + path);
        }
    }

    /**
     * Loads a CSS file
     * @param scene Scene to apply the stylesheet to
     * @param path Path to the file
     */
    public void loadStylesheet(Scene scene, String path) {
        scene.getStylesheets().add(getClass().getResource(path).toExternalForm());
    }

    /**
     * @return Getter for property {@link #stage}
     */
    public FXStage getStage() {
        return stage;
    }

    /**
     * Setter for property {@link #stage}
     * @param stage New stage
     */
    public void setStage(FXStage stage) {
        this.stage = stage;
    }
}
