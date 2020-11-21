package eu.iamgio.libfx.files;

import java.io.File;

/**
 * File chooser
 * @author Gio
 */
public class FileCreator {

    private File folder;

    public FileCreator(File folder) {
        this.folder = folder;
    }

    public FileCreator() {}

    /**
     * Opens a file chooser window
     * @param title File chooser title
     * @param extensions Supported extensions
     * @return Choosen file
     */
    public File create(String title, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        if(folder != null) fileChooser.setInitialDirectory(folder);
        if(title != null) fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(extensions);
        return fileChooser.showSaveDialog(null);
    }
}

