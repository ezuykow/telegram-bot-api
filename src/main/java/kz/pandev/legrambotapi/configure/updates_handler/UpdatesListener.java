package kz.pandev.legrambotapi.configure.updates_handler;

import kz.pandev.legrambotapi.models.types.Update;

import java.util.List;

/**
 * Interface, which must be implemented by updates processor
 * @author ezuykow
 */
public interface UpdatesListener {

    /**
     * If all updates are confirmed
     */
    int CONFIRMED_UPDATES_ALL = -1;
    /**
     * If none updates are confirmed
     */
    int CONFIRMED_UPDATES_NONE = -2;

    /**
     * Callback handler with available updates
     * @param updates available updates
     * @return id of the last processed update which should not be re-delivered
     * There are 2 convenient values:
     * @see #CONFIRMED_UPDATES_ALL
     * @see #CONFIRMED_UPDATES_NONE
     */
    int process(List<Update> updates);
}