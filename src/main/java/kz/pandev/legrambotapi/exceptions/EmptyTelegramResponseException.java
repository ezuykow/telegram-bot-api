package kz.pandev.legrambotapi.exceptions;

/**
 * Exception thrown when response, coming from Telegram bot API server, is empty
 * @author ezuykow
 */
public class EmptyTelegramResponseException extends RuntimeException {

    public EmptyTelegramResponseException() {
        super("Empty response from telegram");
    }
}