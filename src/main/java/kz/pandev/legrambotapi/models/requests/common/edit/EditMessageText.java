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
 * Use this method to edit text and game messages. On success, if the edited message
 * is not an inline message, the edited Message is returned, otherwise True is returned.
 * @author ezuykow
 */
public class EditMessageText extends Request<EditMessageText, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message to edit
     * @param text New text of the message, 1-4096 characters after entities parsing
     */
    public EditMessageText(@NotNull Object chatId, int messageId, @NotNull String text) {
        super(SendResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
            addParameter("text", text);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    /**
     * @param inlineMessageId Identifier of the inline message
     * @param text New text of the message, 1-4096 characters after entities parsing
     */
    public EditMessageText(@NotNull String inlineMessageId, @NotNull String text) {
        super(Response.class);
        addParameter("inline_message_id", inlineMessageId);
        addParameter("text", text);
    }

    //region API

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the message text
     * @return this request
     */
    public EditMessageText parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter entities
     * @param entities List of special entities that appear in message text, which can be specified instead of parse_mode
     * @return this request
     */
    public EditMessageText entities(@NotNull List<MessageEntity> entities) {
        return addParameter("entities", entities);
    }

    /**
     * Set parameter disable_web_page_preview
     * @param disableWebPagePreview Disables link previews for links in this message
     * @return this request
     */
    public EditMessageText disableWebPagePreview(boolean disableWebPagePreview) {
        return addParameter("disable_web_page_preview", disableWebPagePreview);
    }

    /**
     * Set parameter reply_markup
     * @param replyMarkup An inline keyboard.
     * @return this request
     */
    public EditMessageText replyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}