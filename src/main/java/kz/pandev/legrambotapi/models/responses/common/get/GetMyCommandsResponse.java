package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.bot.command.BotCommand;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Telegram bot API server response to GetMyCommands request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetMyCommandsResponse extends Response {

    /**
     * Result as {@link List} of {@link BotCommand}
     */
    @SerializedName("result")
    private List<BotCommand> commands;
}