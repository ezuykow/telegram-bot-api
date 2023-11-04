package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.bot.BotName;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetMyName request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetMyNameResponse extends Response {

    /**
     * Result as {@link BotName}
     */
    @SerializedName("result")
    private BotName botName;
}