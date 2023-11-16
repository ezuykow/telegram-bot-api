package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatMenuButtonResponse;

/**
 * Use this method to get the current value of the bot's menu button in a private chat, or the default menu button.
 * Returns MenuButton on success.
 * @author ezuykow
 */
public class GetChatMenuButton extends Request<GetChatMenuButton, GetChatMenuButtonResponse> {

    public GetChatMenuButton() {
        super(GetChatMenuButtonResponse.class);
    }

    //region API

    /**
     * Set parameter chat_id
     * @param chatId Unique identifier for the target private chat. If not specified, default bot's menu
     *              button will be returned
     * @return this request
     */
    public GetChatMenuButton chatId(long chatId) {
        return addParameter("chat_id", chatId);
    }

    //endregion
}