package kz.pandev.legrambotapi.models.requests;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.Keyboard;
import org.jetbrains.annotations.NotNull;

/**
 * General request for all Send*** methods
 * @author ezuykow
 */
public abstract class AbstractSendRequest<T extends AbstractSendRequest<T>> extends Request<T, SendResponse> {

    protected AbstractSendRequest(@NotNull Object chatId) {
        super(SendResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter message_thread_id
     * @param messageThreadId Unique identifier for the target message thread (topic) of the forum;
     *                       for forum supergroups only
     * @return this request
     */
    public T messageThreadId(int messageThreadId) {
        return addParameter("message_thread_id", messageThreadId);
    }

    /**
     * Set parameter disable_notification
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @return this request
     */
    public T disableNotification(boolean disableNotification) {
        return addParameter("disable_notification", disableNotification);
    }

    /**
     * Set parameter reply_to_message_id
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @return this request
     */
    public T replyToMessageId(int replyToMessageId) {
        return addParameter("reply_to_message_id", replyToMessageId);
    }

    /**
     * Set parameter allow_sending_without_reply
     * @param allowSendingWithoutReply Pass True if the message should be sent even if the specified
     *                                replied-to message is not found
     * @return this request
     */
    public T allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return addParameter("allow_sending_without_reply", allowSendingWithoutReply);
    }

    /**
     * Set parameter reply_markup
     * @param replyMarkup Additional interface options. An inline keyboard, custom reply keyboard, instructions
     *                   to remove reply keyboard or to force a reply from the user.
     * @return this request
     */
    public T replyMarkup(@NotNull Keyboard replyMarkup) {
        return addParameter("reply_markup", replyMarkup);
    }

    /**
     * Set parameter protect_content
     * @param protectContent Protects the contents of the sent message from forwarding and saving
     * @return this request
     */
    public T protectContent(boolean protectContent) {
        return addParameter("protect_content", protectContent);
    }

    //endregion
}