package kz.pandev.legrambotapi.models.requests;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.Keyboard;
import lombok.Getter;

/**
 * General request for all Send*** methods
 * @author ezuykow
 */
@Getter
public abstract class AbstractSendRequest<T extends AbstractSendRequest<T>> extends Request<T, SendResponse> {

    /**
     * Optional. Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    private Integer messageThreadId;
    /**
     * Optional. Sends the message silently. Users will receive a notification with no sound.
     */
    private Boolean disableNotification;
    /**
     * Optional. If the message is a reply, ID of the original message
     */
    private Integer replyToMessageId;
    /**
     * Optional. Pass True if the message should be sent even if the specified replied-to message is not found
     */
    private Boolean allowSendingWithoutReply;
    /**
     * Optional. Additional interface options. An inline keyboard, custom reply keyboard,
     * instructions to remove reply keyboard or to force a reply from the user.
     */
    private Keyboard replyMarkup;
    /**
     * Optional. Protects the contents of the sent message from forwarding and saving
     */
    private Boolean protectContent;

    protected AbstractSendRequest(Object chatId) {
        super(SendResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter {@link AbstractSendRequest#messageThreadId}
     * @param messageThreadId new parameter value
     * @return this request
     */
    public T messageThreadId(int messageThreadId) {
        this.messageThreadId = messageThreadId;
        return addParameter("message_thread_id", messageThreadId);
    }

    /**
     * Set parameter {@link AbstractSendRequest#disableNotification}
     * @param disableNotification new parameter value
     * @return this request
     */
    public T disableNotification(boolean disableNotification) {
        this.disableNotification = disableNotification;
        return addParameter("disable_notification", disableNotification);
    }

    /**
     * Set parameter {@link AbstractSendRequest#replyToMessageId}
     * @param replyToMessageId new parameter value
     * @return this request
     */
    public T replyToMessageId(int replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return addParameter("reply_to_message_id", replyToMessageId);
    }

    /**
     * Set parameter {@link AbstractSendRequest#allowSendingWithoutReply}
     * @param allowSendingWithoutReply new parameter value
     * @return this request
     */
    public T allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        this.allowSendingWithoutReply = allowSendingWithoutReply;
        return addParameter("allow_sending_without_reply", allowSendingWithoutReply);
    }

    /**
     * Set parameter {@link AbstractSendRequest#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this request
     */
    public T replyMarkup(Keyboard replyMarkup) {
        this.replyMarkup = replyMarkup;
        return addParameter("reply_markup", replyMarkup);
    }

    /**
     * Set parameter {@link AbstractSendRequest#protectContent}
     * @param protectContent new parameter value
     * @return this request
     */
    public T protectedContent(boolean protectContent) {
        this.protectContent = protectContent;
        return addParameter("protect_content", protectContent);
    }

    //endregion
}