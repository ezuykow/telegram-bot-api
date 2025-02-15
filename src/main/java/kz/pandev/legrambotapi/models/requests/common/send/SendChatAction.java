package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.utils.enums.ChatAction;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method when you need to tell the user that something is happening on the bot's side.
 * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients
 * clear its typing status). Returns True on success.
 * @author ezuykow
 */
public class SendChatAction extends Request<SendChatAction, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param action Type of action to broadcast as {@link ChatAction}
     */
    public SendChatAction(@NotNull Object chatId, @NotNull ChatAction action) {
        super(Response.class);
        addParameter("chat_id", chatId);
        addParameter("action", action.name());
    }

    //region API

    /**
     * Set parameter message_thread_id
     * @param messageThreadId Unique identifier for the target message thread; supergroups only
     * @return this request;
     */
    public SendChatAction messageThreadId(int messageThreadId) {
        return addParameter("message_thread_id", messageThreadId);
    }

    //endregion
}