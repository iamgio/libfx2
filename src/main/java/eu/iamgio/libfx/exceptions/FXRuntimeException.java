package eu.iamgio.libfx.exceptions;

/**
 * Minor exception for errors inside the library
 * @author Gio
 */
public class FXRuntimeException extends RuntimeException {

    public FXRuntimeException(String message) {
        super(message);
    }
}
