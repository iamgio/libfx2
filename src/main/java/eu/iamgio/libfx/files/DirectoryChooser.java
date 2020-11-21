package eu.iamgio.libfx.files;

import java.io.File;

/**
 * Directory chooser
 * @author Gio
 */
public class DirectoryChooser {

    /**
     * Opens a directory chooser window
     * @param name Name of the window
     * @param initialDir Starting directory
     * @return Choosen directory
     */
    public File choose(String name, File initialDir) {
        javafx.stage.DirectoryChooser chooser = new javafx.stage.DirectoryChooser();
        chooser.setTitle(name);
        if(initialDir != null) chooser.setInitialDirectory(initialDir);
        return chooser.showDialog(null);
    }
}
