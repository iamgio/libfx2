package eu.iamgio.libfx.files;

import java.io.File;

/**
 * Font chooser
 * @author Gio
 */
public class FileChooser {

    /**
     * Opens a file chooser window
     * @param description File chooser description
     * @param extensions Supported extensions
     * @return Choosen file
     */
    public File choose(String description, String...extensions) {
        String[] exts = new String[extensions.length];
        description += " (";
        StringBuilder descriptionBuilder = new StringBuilder(description);
        for(int i = 0; i < extensions.length; i++) {
            exts[i] = "*." + extensions[i].toUpperCase();
            descriptionBuilder.append("*.").append(extensions[i].toUpperCase());
            if(i != exts.length - 1) {
                descriptionBuilder.append(", ");
            }
        }
        description = descriptionBuilder.toString() + ")";
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        javafx.stage.FileChooser.ExtensionFilter extFilter = new javafx.stage.FileChooser.ExtensionFilter(
                description, exts);
        fileChooser.getExtensionFilters().addAll(extFilter);
        return fileChooser.showOpenDialog(null);
    }
}
