package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to add a message to the list of pinned messages in a chat.
 * If the chat is not a private chat, the bot must be an administrator in the chat for this
 * to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages'
 * administrator right in a channel. Returns True on success.
 * @author ezuykow
 */
@Getter
public class PinChatMessage extends Request<PinChatMessage, Response> {

    /**
     * Optional. Pass True if it is not necessary to send a notification to all chat members about the
     * new pinned message. Notifications are always disabled in channels and private chats.
     */
    @Nullable
    private Boolean disableNotification;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of a message to pin
     */
    public PinChatMessage(@NotNull Object chatId, int messageId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter {@link PinChatMessage#disableNotification}
     * @param disableNotification new parameter value
     * @return this request
     */
    public PinChatMessage disableNotification(boolean disableNotification) {
        this.disableNotification = disableNotification;
        return addParameter("disable_notification", disableNotification);
    }

    //endregion
}