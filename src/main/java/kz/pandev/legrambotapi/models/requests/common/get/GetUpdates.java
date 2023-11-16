package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetUpdatesResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Request for Telegram bot API method "getUpdates"
 * @author ezuykow
 */
public class GetUpdates extends Request<GetUpdates, GetUpdatesResponse> {

    public GetUpdates() {
        super(GetUpdatesResponse.class);
    }

    //region API

    /**
     * Change the offset parameter of request
     * @param offset Identifier of the first update to be returned. Must be greater by one than the highest among
     *              the identifiers of previously received updates. By default, updates starting with the earliest
     *              unconfirmed update are returned. An update is considered confirmed as soon as getUpdates is
     *              called with an offset higher than its update_id. The negative offset can be specified to retrieve
     *              updates starting from -offset update from the end of the updates queue.
     *              All previous updates will be forgotten.
     * @return this request
     */
    public GetUpdates offset(int offset) {
        return addParameter("offset", offset);
    }

    /**
     * Change the limit parameter of request
     * @param limit Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * @return this request
     */
    public GetUpdates limit(int limit) {
        return addParameter("limit", limit);
    }

    /**
     * Change the timeout parameter of request
     * @param timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive,
     *               short polling should be used for testing purposes only.
     * @return this request
     */
    public GetUpdates timeout(int timeout) {
        return addParameter("timeout", timeout);
    }

    /**
     * Change the allowed_updates parameter of request
     * @param allowedUpdates List of the update types you want your bot to receive. Specify an empty list to receive
     *                       all update types except chat_member (default). If not specified,
     *                       the previous setting will be used.
     * @return this request
     */
    public GetUpdates allowedUpdates(@NotNull String... allowedUpdates) {
        return addParameter("allowed_updates", allowedUpdates);
    }

    //endregion
}