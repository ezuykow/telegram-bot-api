package kz.pandev.legrambotapi.models.temp;

/**
 * Represents an objects, which can be cancelled
 * @author ezuykow
 */
@FunctionalInterface
public interface Cancellable {

    void cancel();
}