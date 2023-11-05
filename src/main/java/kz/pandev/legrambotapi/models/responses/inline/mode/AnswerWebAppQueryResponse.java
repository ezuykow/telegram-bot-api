package kz.pandev.legrambotapi.models.responses.inline.mode;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.inline.mode.SentWebAppMessage;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to AnswerWebAppQuery request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class AnswerWebAppQueryResponse extends Response {

    /**
     * Result as {@link SentWebAppMessage}
     */
    @SerializedName("result")
    private SentWebAppMessage sentWebAppMessage;
}