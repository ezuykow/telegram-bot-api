package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Use this method to edit captions of messages. On success, if the edited message
 * is not an inline message, the edited Message is returned, otherwise True is returned.
 * @author ezuykow
 */
public class EditMessageCaption extends Request<EditMessageCaption, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message to edit
     */
    public EditMessageCaption(@NotNull Object chatId, int messageId) {
        super(SendResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    /**
     * @param inlineMessageId Identifier of the inline message
     */
    public EditMessageCaption(@NotNull String inlineMessageId) {
        super(Response.class);
        addParameter("inline_message_id", inlineMessageId);
    }

    //region API

    /**
     * Set parameter caption
     * @param caption New caption of the message, 0-1024 characters after entities parsing
     * @return this request
     */
    public EditMessageCaption caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the message caption
     * @return this request
     */
    public EditMessageCaption parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter entities
     * @param entities List of special entities that appear in message text, which can be specified instead of parse_mode
     * @return this request
     */
    public EditMessageCaption entities(@NotNull List<MessageEntity> entities) {
        return addParameter("entities", entities);
    }

    /**
     * Set parameter reply_markup
     * @param replyMarkup An inline keyboard
     * @return this request
     */
    public EditMessageCaption replyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}