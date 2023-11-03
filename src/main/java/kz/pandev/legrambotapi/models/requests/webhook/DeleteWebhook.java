package kz.pandev.legrambotapi.models.requests.webhook;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;

/**
 * Request for Telegram bot API method "setWebhook"
 * @author ezuykow
 */
@Getter
public class DeleteWebhook extends Request<DeleteWebhook, Response> {

    /**
     * Optional. Pass True to drop all pending updates
     */
    private Boolean dropPendingUpdates;

    public DeleteWebhook() {
        super(Response.class);
    }

    //region API

    /**
     * Set webhook {@link DeleteWebhook#dropPendingUpdates} parameter
     * @param dropPendingUpdates new drop pending updates parameter
     * @return this request
     */
    public DeleteWebhook dropPendingUpdates(boolean dropPendingUpdates) {
        this.dropPendingUpdates = dropPendingUpdates;
        return addParameter("drop_pending_updates", this.dropPendingUpdates);
    }

    //endregion
}