package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetUpdatesResponse;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Request for Telegram bot API method "getUpdates"
 * @author ezuykow
 */
@Getter
public class GetUpdates extends Request<GetUpdates, GetUpdatesResponse> {

    /**
     * Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers
     * of previously received updates. By default, updates starting with the earliest unconfirmed update are returned.
     * An update is considered confirmed as soon as getUpdates is called with an offset higher than its update_id.
     * The negative offset can be specified to retrieve updates starting from -offset update from the end of the
     * updates queue. All previous updates will be forgotten.
     */
    @Nullable
    private Integer offset;
    /**
     * Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     */
    @Nullable
    private Integer limit;
    /**
     * Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling.
     * Should be positive, short polling should be used for testing purposes only.
     */
    @Nullable
    private Integer timeout;
    /**
     * List of the update types you want your bot to receive.
     * Specify an empty list to receive all update types except chat_member (default). If not specified, the previous
     * setting will be used.
     */
    @Nullable
    private List<String> allowedUpdates;

    public GetUpdates() {
        super(GetUpdatesResponse.class);
    }

    //region API

    /**
     * Change the {@link GetUpdates#offset} parameter of request
     * @param offset new offset
     * @return this request
     */
    public GetUpdates offset(int offset) {
        this.offset = offset;
        return addParameter("offset", offset);
    }

    /**
     * Change the {@link GetUpdates#limit} parameter of request
     * @param limit new limit
     * @return this request
     */
    public GetUpdates limit(int limit) {
        this.limit = limit;
        return addParameter("limit", limit);
    }

    /**
     * Change the {@link GetUpdates#timeout} parameter of request
     * @param timeout new timeout
     * @return this request
     */
    public GetUpdates timeout(int timeout) {
        this.timeout = timeout;
        return addParameter("timeout", timeout);
    }


    /**
     * Change the {@link GetUpdates#allowedUpdates} parameter of request
     * @param allowedUpdates new allowed updates
     * @return this request
     */
    public GetUpdates allowedUpdates(String... allowedUpdates) {
        this.allowedUpdates = Arrays.asList(allowedUpdates);
        return addParameter("allowed_updates", allowedUpdates);
    }

    //endregion
}