package eu.iamgio.libfx.util;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * @author Gio
 */
public class Roots {

    private Roots() {}

    /**
     * Gets a node from given ID
     * @param pane Pane
     * @param id Node ID
     * @return Node with given ID or null
     */
    public static Node getById(Pane pane, String id) {
        return pane.getChildrenUnmodifiable().stream().filter(n -> n.getId() != null && n.getId().equals(id))
                .findFirst().orElse(null);
    }
}
