package kz.pandev.legrambotapi.models.requests.inline.mode;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.inline.mode.AnswerWebAppQueryResponse;
import kz.pandev.legrambotapi.models.types.inline.mode.results.InlineQueryResult;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to set the result of an interaction with a Web App and send a corresponding message on
 * behalf of the user to the chat from which the query originated. On success, a SentWebAppMessage object is returned.
 * @author ezuykow
 */
public class AnswerWebAppQuery extends Request<AnswerWebAppQuery, AnswerWebAppQueryResponse> {

    /**
     * @param webAppQueryId Unique identifier for the query to be answered
     * @param result {@link InlineQueryResult} describing the message to be sent
     */
    public AnswerWebAppQuery(@NotNull String webAppQueryId, @NotNull InlineQueryResult<?> result) {
        super(AnswerWebAppQueryResponse.class);
        addParameter("web_app_query_id", webAppQueryId);
        addParameter("result", result);
    }
}