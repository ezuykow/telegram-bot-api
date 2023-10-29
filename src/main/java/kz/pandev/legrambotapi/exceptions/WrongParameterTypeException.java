package kz.pandev.legrambotapi.exceptions;

/**
 * Exception thrown when parameter type is wrong
 * @author ezuykow
 */
public class WrongParameterTypeException extends RuntimeException {

    public WrongParameterTypeException(String message) {
        super(message);
    }
}