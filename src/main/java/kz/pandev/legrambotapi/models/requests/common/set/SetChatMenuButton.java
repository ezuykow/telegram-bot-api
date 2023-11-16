package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.menu.MenuButton;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to change the bot's menu button in a private chat, or the default menu button.
 * Returns True on success.
 * @author ezuykow
 */
public class SetChatMenuButton extends Request<SetChatMenuButton, Response> {

    public SetChatMenuButton() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter chat_id
     * @param chatId Unique identifier for the target private chat. If not specified,
     *              default bot's menu button will be changed
     * @return this
     */
    public SetChatMenuButton chatId(long chatId) {
        return addParameter("chat_id", chatId);
    }

    /**
     * Set parameter menu_button
     * @param menuButton The bot's new menu button. Defaults to MenuButtonDefault
     * @return this
     */
    public SetChatMenuButton menuButton(@NotNull MenuButton menuButton) {
        return addParameter("menu_button", menuButton);
    }

    //endregion
}