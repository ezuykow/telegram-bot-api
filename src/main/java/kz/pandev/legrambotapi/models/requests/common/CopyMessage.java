package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.MessageIdResponse;
import kz.pandev.legrambotapi.models.types.Keyboard;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Use this method to copy messages of any kind. Service messages and invoice messages can't be copied.
 * A quiz poll can be copied only if the value of the field correct_option_id is known to the bot.
 * The method is analogous to the method forwardMessage, but the copied message doesn't have a link
 * to the original message. Returns the MessageId of the sent message on success.
 * @author ezuykow
 */
public class CopyMessage extends Request<CopyMessage, MessageIdResponse> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
     * @param messageId Message identifier in the chat specified in from_chat_id
     */
    public CopyMessage(@NotNull Object chatId, @NotNull Object fromChatId, int messageId) {
        super(MessageIdResponse.class);
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
     * Set parameter message_thread_id
     * @param messageThreadId Unique identifier for the target message thread (topic) of the forum;
     *                       for forum supergroups only
     * @return this request
     */
    public CopyMessage messageThreadId(int messageThreadId) {
        return addParameter("message_thread_id", messageThreadId);
    }

    /**
     * Set parameter caption
     * @param caption New caption for media, 0-1024 characters after entities parsing. If not specified,
     *               the original caption is kept
     * @return this request
     */
    public CopyMessage caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the new caption.
     * @return this request
     */
    public CopyMessage parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter caption_entities
     * @param entities List of special entities that appear in the new caption,
     *                which can be specified instead of parse_mode
     * @return this request
     */
    public CopyMessage captionEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter disable_notification
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @return this request
     */
    public CopyMessage disableNotification(boolean disableNotification) {
        return addParameter("disable_notification", disableNotification);
    }

    /**
     * Set parameter allow_sending_without_reply
     * @param allowSendingWithoutReply Pass True if the message should be sent even if the specified replied-to
     *                                message is not found
     * @return this request
     */
    public CopyMessage allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return addParameter("allow_sending_without_reply", allowSendingWithoutReply);
    }

    /**
     * Set parameter reply_to_message_id
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @return this request
     */
    public CopyMessage replyToMessageId(int replyToMessageId) {
        return addParameter("reply_to_message_id", replyToMessageId);
    }

    /**
     * Set parameter reply_markup
     * @param replyMarkup Additional interface options. An inline keyboard, custom reply keyboard, instructions
     *                   to remove reply keyboard or to force a reply from the user.
     * @return this request
     */
    public CopyMessage replyMarkup(Keyboard replyMarkup) {
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}