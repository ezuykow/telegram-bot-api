package kz.pandev.legrambotapi.models.requests.webhook;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;

/**
 * Request for Telegram bot API method "setWebhook"
 * @author ezuykow
 */
public class DeleteWebhook extends Request<DeleteWebhook, Response> {

    public DeleteWebhook() {
        super(Response.class);
    }

    //region API

    /**
     * Set webhook's drop_pending_updates parameter
     * @param dropPendingUpdates Pass True to drop all pending updates
     * @return this request
     */
    public DeleteWebhook dropPendingUpdates(boolean dropPendingUpdates) {
        return addParameter("drop_pending_updates", dropPendingUpdates);
    }

    //endregion
}