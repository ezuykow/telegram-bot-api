package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.bot.BotDescription;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetMyDescription request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetMyDescriptionResponse extends Response {

    /**
     * Result as {@link BotDescription}
     */
    @SerializedName("result")
    private BotDescription botDescription;
}