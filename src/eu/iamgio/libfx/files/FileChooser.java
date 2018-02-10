package eu.iamgio.libfx.files;

import com.sun.istack.internal.Nullable;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Font chooser
 * @author Gio
 */
public class FileChooser {

    /**
     * Opens a file chooser window
     * @param title File chooser title
     * @param multi <tt>true</tt> for multiple files
     * @param extensions Supported extensions
     * @return Choosen file
     */
    private List<File> choose(@Nullable String title, boolean multi, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        if(title != null) fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(extensions);
        return multi ? fileChooser.showOpenMultipleDialog(null) : Arrays.asList(fileChooser.showOpenDialog(null));
    }

    /**
     * Opens a file chooser window
     * @param title File chooser title
     * @param extensions Supported extensions
     * @return Choosen file
     */
    public File choose(@Nullable String title, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        return choose(title, false, extensions).get(0);
    }

    /**
     * Opens a file chooser window to open multiple files
     * @param title File chooser title
     * @param extensions Supported extensions
     * @return Choosen file(s)
     */
    public List<File> chooseMulti(@Nullable String title, javafx.stage.FileChooser.ExtensionFilter...extensions) {
        return choose(title, true, extensions);
    }
}
