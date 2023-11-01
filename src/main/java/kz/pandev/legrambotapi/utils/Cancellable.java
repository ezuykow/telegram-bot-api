package kz.pandev.legrambotapi.utils;

/**
 * Represents an objects, which can be cancelled
 * @author ezuykow
 */
@FunctionalInterface
public interface Cancellable {

    void cancel();
}