package kz.pandev.legrambotapi.models.requests.inline.mode;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.inline.mode.InlineQueryResultsButton;
import kz.pandev.legrambotapi.models.types.inline.mode.results.InlineQueryResult;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Use this method to send answers to an inline query. On success, True is returned.
 * No more than 50 results per query are allowed.
 * @author ezuykow
 */
@Getter
public class AnswerInlineQuery extends Request<AnswerInlineQuery, Response> {

    /**
     * Optional. The maximum amount of time in seconds that the result of the inline query may be cached on the server.
     * Defaults to 300.
     */
    @Nullable
    private Integer cacheTime;
    /**
     * Optional. Pass True if results may be cached on the server side only for the user that sent the query.
     * By default, results may be returned to any user who sends the same query.
     */
    @Nullable
    private Boolean isPersonal;
    /**
     * Optional. Pass the offset that a client should send in the next query with the same text to receive more results.
     * Pass an empty string if there are no more results or if you don't support pagination.
     * Offset length can't exceed 64 bytes.
     */
    @Nullable
    private String nextOffset;
    /**
     * Optional. button to be shown above inline query results
     */
    @Nullable
    private InlineQueryResultsButton button;

    /**
     * @param inlineQueryId Unique identifier for the answered query
     * @param results Array of results for the inline query
     */
    public AnswerInlineQuery(@NotNull String inlineQueryId, @NotNull InlineQueryResult<?>... results) {
        this(inlineQueryId, Arrays.asList(results));
    }

    /**
     * @param inlineQueryId Unique identifier for the answered query
     * @param results List of results for the inline query
     */
    public AnswerInlineQuery(@NotNull String inlineQueryId, @NotNull List<InlineQueryResult<?>> results) {
        super(Response.class);
        addParameter("inline_query_id", inlineQueryId);
        addParameter("results", results);
    }

    //region API

    /**
     * Set parameter {@link AnswerInlineQuery#cacheTime}
     * @param cacheTime new parameter value
     * @return this request
     */
    public AnswerInlineQuery cacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
        return addParameter("cache_time", cacheTime);
    }

    /**
     * Set parameter {@link AnswerInlineQuery#isPersonal}
     * @param isPersonal new parameter value
     * @return this request
     */
    public AnswerInlineQuery isPersonal(boolean isPersonal) {
        this.isPersonal = isPersonal;
        return addParameter("is_personal", isPersonal);
    }

    /**
     * Set parameter {@link AnswerInlineQuery#nextOffset}
     * @param nextOffset new parameter value
     * @return this request
     */
    public AnswerInlineQuery nextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
        return addParameter("next_offset", nextOffset);
    }

    /**
     * Set parameter {@link AnswerInlineQuery#button}
     * @param button new parameter value
     * @return this request
     */
    public AnswerInlineQuery button(InlineQueryResultsButton button) {
        this.button = button;
        return addParameter ("button", button);
    }

    //endregion
}