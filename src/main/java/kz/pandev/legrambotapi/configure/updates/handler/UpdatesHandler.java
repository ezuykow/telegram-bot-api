package kz.pandev.legrambotapi.configure.updates.handler;

import kz.pandev.legrambotapi.addons.update.ExtendedUpdate;
import kz.pandev.legrambotapi.configure.TelegramBot;
import kz.pandev.legrambotapi.exceptions.UnsuccessfulGetUpdatesRequestException;
import kz.pandev.legrambotapi.exceptions.handler.ExceptionHandler;
import kz.pandev.legrambotapi.configure.Callback;
import kz.pandev.legrambotapi.models.requests.common.get.GetUpdates;
import kz.pandev.legrambotapi.models.responses.common.get.GetUpdatesResponse;
import kz.pandev.legrambotapi.utils.Cancellable;
import kz.pandev.legrambotapi.models.types.Update;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handler of new updates on Telegram bot API server
 * @author ezuykow
 */
public class UpdatesHandler {

    /**
     * Telegram bot entity
     */
    private TelegramBot telegramBot;
    /**
     * Updates processor
     */
    private UpdatesListener updatesListener;
    /**
     * Exception processor
     */
    private ExceptionHandler exceptionHandler;
    /**
     * Request for Telegram bot API method "getUpdates"
     */
    private GetUpdates getUpdatesRequest;
    /**
     * Cancellable GetUpdates request to Telegram bot API
     */
    private Cancellable pendingRequest;

    /**
     * Updates handler sleep timeout
     */
    private final long sleepTimeout;

    public UpdatesHandler(long sleepTimeout) {
        this.sleepTimeout = sleepTimeout;
    }

    //region API

    /**
     * Start to handle updates
     * @param telegramBot telegram bot entity
     * @param updatesListener updates processor
     * @param exceptionHandler exception processor
     * @param getUpdatesRequest GetUpdates request
     */
    public void start(TelegramBot telegramBot, UpdatesListener updatesListener, ExceptionHandler exceptionHandler,
                      GetUpdates getUpdatesRequest)
    {
        this.telegramBot = telegramBot;
        this.updatesListener = updatesListener;
        this.exceptionHandler = exceptionHandler;
        this.getUpdatesRequest = getUpdatesRequest;
        getUpdates();
    }

    /**
     * Stop to handle updates
     */
    public void stop() {
        telegramBot = null;
        updatesListener = null;
        exceptionHandler = null;
        if (pendingRequest != null) {
            pendingRequest.cancel();
            pendingRequest = null;
        }
    }

    //endregion
    //region Utils

    private void getUpdates() {
        if (telegramBot != null && updatesListener != null) {
            pendingRequest = telegramBot.execute(getUpdatesRequest, getUpdateExecCallback());
        }
    }

    private Callback<GetUpdates, GetUpdatesResponse> getUpdateExecCallback() {
        return new Callback<>() {
            @Override
            public void onResponse(GetUpdates request, GetUpdatesResponse response) {
                boolean requestSuccessful = response.isOk() && response.getUpdates() != null
                        && !response.getUpdates().isEmpty();
                if (requestSuccessful) {
                    processSuccessfulResponse(request, response);
                } else {
                    processUnsuccessfulResponse(response);
                }
                getUpdates();
            }

            @Override
            public void onFailure(GetUpdates request, Exception e) {
                if (e.getMessage().equals("Canceled")) {
                    return;
                }
                if (exceptionHandler != null) {
                    exceptionHandler.process(new UnsuccessfulGetUpdatesRequestException(e));
                } else {
                    Logger.getGlobal().log(Level.INFO, "Update listener failure", e);
                }
                sleep();
                getUpdates();
            }
        };
    }

    private void processSuccessfulResponse(GetUpdates request, GetUpdatesResponse response) {
        List<ExtendedUpdate> updates = response.getUpdates();
        int lastConfirmedUpdate = updatesListener.process(updates);

        if (lastConfirmedUpdate != UpdatesListener.CONFIRMED_UPDATES_NONE) {
            int newOffset = (lastConfirmedUpdate == UpdatesListener.CONFIRMED_UPDATES_ALL)
                    ? updates.get(updates.size() - 1).getUpdateId() + 1
                    : lastConfirmedUpdate + 1;
            request.offset(newOffset);
        }
    }

    private void processUnsuccessfulResponse(GetUpdatesResponse response) {
        if (!response.isOk()) {
            String message = "GetUpdates failed with error code " + response.getErrorCode()
                    + " (" + response.getDescription() + ")";
            if (exceptionHandler != null) {
                exceptionHandler.process(new UnsuccessfulGetUpdatesRequestException(message));
            } else {
                Logger.getGlobal().log(Level.INFO, message);
            }
        }
        sleep();
    }

    private void sleep() {
        try {
            if (sleepTimeout > 0) {
                Thread.sleep(sleepTimeout);
            }
        } catch (InterruptedException e) {
            //Ignore if thread is interrupted
            Thread.currentThread().interrupt();
        }
    }

    //endregion
}