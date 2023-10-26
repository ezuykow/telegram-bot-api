package kz.pandev.legrambotapi.exceptions;

/**
 * Exception thrown when GetUpdates request to Telegram bot API server execute with error
 * @author ezuykow
 */
public class UnsuccessfulGetUpdatesRequestException extends RuntimeException {

    public UnsuccessfulGetUpdatesRequestException(String message) {
        super(message);
    }

    public UnsuccessfulGetUpdatesRequestException(Throwable cause) {
        super(cause);
    }
}