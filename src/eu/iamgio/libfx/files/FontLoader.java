package eu.iamgio.libfx.files;

import javafx.scene.text.Font;

/**
 * Font loader
 * @author Gio
 */
public class FontLoader {

    /**
     * Loads a font
     * @param clazz Class
     * @param path Path to the file
     * @param size Font size
     */
    public void load(Class<?> clazz, String path, int size) {
        Font.loadFont(clazz.getResource(path).toExternalForm(), size);
    }
}
