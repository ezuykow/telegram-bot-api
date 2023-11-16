package kz.pandev.legrambotapi.models.requests.common.unpin;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat,
 * the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages'
 * administrator right in a supergroup or 'can_edit_messages' administrator right in a channel.
 * Returns True on success.
 * @author ezuykow
 */
public class UnpinAllChatMessages extends Request<UnpinAllChatMessages, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public UnpinAllChatMessages(@NotNull Object chatId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}