package kz.pandev.legrambotapi.exceptions.handler;

/**
 * Interface, which must be implemented by handler of exceptions that occurs in UpdatesListener
 * @author ezuykow
 */
public interface ExceptionHandler {

    /**
     * Method to process handled exception
     * @param e handled exception
     */
    void process(Exception e);
}