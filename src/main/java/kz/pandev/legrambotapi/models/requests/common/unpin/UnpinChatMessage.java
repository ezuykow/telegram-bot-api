package kz.pandev.legrambotapi.models.requests.common.unpin;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to remove a message from the list of pinned messages in a chat.
 * If the chat is not a private chat, the bot must be an administrator in the chat for this to work and
 * must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator
 * right in a channel. Returns True on success.
 * @author ezuykow
 */
public class UnpinChatMessage extends Request<UnpinChatMessage, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public UnpinChatMessage(@NotNull Object chatId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter message_id
     * @param messageId Identifier of a message to unpin. If not specified, the most recent pinned message
     *                 (by sending date) will be unpinned.
     * @return this request
     */
    public UnpinChatMessage messageId(int messageId) {
        return addParameter("message_id", messageId);
    }

    //endregion
}