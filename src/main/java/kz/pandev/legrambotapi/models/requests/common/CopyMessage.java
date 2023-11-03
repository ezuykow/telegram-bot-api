package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.MessageIdResponse;
import kz.pandev.legrambotapi.models.types.Keyboard;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Use this method to copy messages of any kind. Service messages and invoice messages can't be copied.
 * A quiz poll can be copied only if the value of the field correct_option_id is known to the bot.
 * The method is analogous to the method forwardMessage, but the copied message doesn't have a link
 * to the original message. Returns the MessageId of the sent message on success.
 * @author ezuykow
 */
@Getter
public class CopyMessage extends Request<CopyMessage, MessageIdResponse> {

    /**
     * Optional. Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    private Integer messageThreadId;
    /**
     * Optional. New caption for media, 0-1024 characters after entities parsing. If not specified, the original caption is kept
     */
    private String caption;
    /**
     * Optional. Mode for parsing entities in the new caption.
     * @see ParseMode
     */
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in the new caption, which can be specified instead of parse_mode
     */
    private List<MessageEntity> captionEntities;
    /**
     * Optional. Sends the message silently. Users will receive a notification with no sound.
     */
    private Boolean disableNotification;
    /**
     * Optional. Pass True if the message should be sent even if the specified replied-to message is not found
     */
    private Boolean allowSendingWithoutReply;
    /**
     * Optional. If the message is a reply, ID of the original message
     */
    private Integer replyToMessageId;
    /**
     * Optional. Additional interface options. An inline keyboard, custom reply keyboard,
     * instructions to remove reply keyboard or to force a reply from the user.
     */
    private Keyboard replyMarkup;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
     * @param messageId Message identifier in the chat specified in from_chat_id
     */
    public CopyMessage(@NotNull Object chatId, @NotNull Object fromChatId, int messageId) {
        super(MessageIdResponse.class);
        addParameter("chat_id", chatId);
        addParameter("from_chat_id", fromChatId);
        addParameter("message_id", messageId);
    }

    //region API

    /**
     * Set parameter {@link CopyMessage#messageThreadId}
     * @param messageThreadId new parameter value
     * @return this request
     */
    public CopyMessage messageThreadId(int messageThreadId) {
        this.messageThreadId = messageThreadId;
        return addParameter("message_thread_id", messageThreadId);
    }

    /**
     * Set parameter {@link CopyMessage#caption}
     * @param caption new parameter value
     * @return this request
     */
    public CopyMessage caption(@NotNull String caption) {
        this.caption = caption;
        return addParameter("caption", caption);
    }

    /**
     * Set parameter {@link CopyMessage#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public CopyMessage parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link CopyMessage#captionEntities}
     * @param entities new parameter value
     * @return this request
     */
    public CopyMessage captionEntities(@NotNull List<MessageEntity> entities) {
        this.captionEntities = entities;
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter {@link CopyMessage#disableNotification}
     * @param disableNotification new parameter value
     * @return this request
     */
    public CopyMessage disableNotification(boolean disableNotification) {
        this.disableNotification = disableNotification;
        return addParameter("disable_notification", disableNotification);
    }

    /**
     * Set parameter {@link CopyMessage#allowSendingWithoutReply}
     * @param allowSendingWithoutReply new parameter value
     * @return this request
     */
    public CopyMessage allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        this.allowSendingWithoutReply = allowSendingWithoutReply;
        return addParameter("allow_sending_without_reply", allowSendingWithoutReply);
    }

    /**
     * Set parameter {@link CopyMessage#replyToMessageId}
     * @param replyToMessageId new parameter value
     * @return this request
     */
    public CopyMessage replyToMessageId(int replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return addParameter("reply_to_message_id", replyToMessageId);
    }

    /**
     * Set parameter {@link CopyMessage#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this request
     */
    public CopyMessage replyMarkup(Keyboard replyMarkup) {
        this.replyMarkup = replyMarkup;
        return addParameter("reply_markup", replyMarkup);
    }
    //endregion
}