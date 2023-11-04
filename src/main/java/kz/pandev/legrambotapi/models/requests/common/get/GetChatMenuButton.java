package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatMenuButtonResponse;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to get the current value of the bot's menu button in a private chat, or the default menu button.
 * Returns MenuButton on success.
 * @author ezuykow
 */
@Getter
public class GetChatMenuButton extends Request<GetChatMenuButton, GetChatMenuButtonResponse> {

    /**
     * Unique identifier for the target private chat. If not specified, default bot's menu button will be returned
     */
    @Nullable
    private Long chatId;

    public GetChatMenuButton() {
        super(GetChatMenuButtonResponse.class);
    }

    //region API

    /**
     * Set parameter {@link GetChatMenuButton#chatId}
     * @param chatId new parameter value
     * @return this request
     */
    public GetChatMenuButton chatId(long chatId) {
        this.chatId = chatId;
        return addParameter("chat_id", chatId);
    }

    //endregion
}