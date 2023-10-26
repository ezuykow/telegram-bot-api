package kz.pandev.legrambotapi.exceptions;

/**
 * Exception thrown when request to Telegram bot API server execute with error
 * @author ezuykow
 */
public class RequestExecutionException extends RuntimeException {

    public RequestExecutionException(Throwable cause) {
        super(cause);
    }
}