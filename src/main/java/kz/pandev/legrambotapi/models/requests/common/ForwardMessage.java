package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to forward messages of any kind. Service messages can't be forwarded.
 * On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class ForwardMessage extends Request<ForwardMessage, SendResponse> {

    /**
     * Optional. Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    @Nullable
    private Integer messageThreadId;
    /**
     * Optional. Sends the message silently. Users will receive a notification with no sound.
     */
    @Nullable
    private Boolean disableNotification;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
     * @param messageId Message identifier in the chat specified in from_chat_id
     */
    public ForwardMessage(@NotNull Object chatId, @NotNull Object fromChatId, int messageId) {
        super(SendResponse.class);
        if ((chatId instanceof Number || chatId instanceof String)
                && (fromChatId instanceof Number || fromChatId instanceof String)) {
            addParameter("chat_id", chatId);
            addParameter("from_chat_id", fromChatId);
            addParameter("message_id", messageId);
        } else {
            throw new WrongParameterTypeException("Type of parameters chatId and fromChatId must be Number or " +
                    "String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter {@link ForwardMessage#messageThreadId}
     * @param messageThreadId new parameter value
     * @return this request
     */
    public ForwardMessage messageThreadId(int messageThreadId) {
        this.messageThreadId = messageThreadId;
        return addParameter("message_thread_id", messageThreadId);
    }

    /**
     * Set parameter {@link ForwardMessage#disableNotification}
     * @param disableNotification new parameter value
     * @return this request
     */
    public ForwardMessage disableNotification(boolean disableNotification) {
        this.disableNotification = disableNotification;
        return addParameter("disable_notification", disableNotification);
    }

    //endregion
}