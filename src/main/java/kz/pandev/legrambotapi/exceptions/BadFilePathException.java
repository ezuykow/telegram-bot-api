package kz.pandev.legrambotapi.exceptions;

/**
 * Exception thrown when field file_path of Telegram File type is incorrect
 * @author ezuykow
 */
@SuppressWarnings("unused") /*Unused methods warning*/
public class BadFilePathException extends RuntimeException {

    public BadFilePathException() {
        super("Bad file_path field value of File object");
    }

    public BadFilePathException(Throwable cause) {
        super(cause);
    }
}