package kz.pandev.legrambotapi.models.responses.common;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to request's, which result is Poll
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class PollResponse extends Response {

    /**
     * Result as {@link Poll}
     */
    @SerializedName("result")
    private Poll poll;
}