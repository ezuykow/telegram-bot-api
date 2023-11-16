package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to edit only the reply markup of messages.
 * On success, if the edited message is not an inline message, the edited Message is returned,
 * otherwise True is returned.
 * @author ezuykow
 */
public class EditMessageReplyMarkup extends Request<EditMessageReplyMarkup, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message to edit
     */
    public EditMessageReplyMarkup(@NotNull Object chatId, int messageId) {
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
    public EditMessageReplyMarkup(@NotNull String inlineMessageId) {
        super(Response.class);
        addParameter("inline_message_id", inlineMessageId);
    }

    //region API

    /**
     * Set parameter reply_markup
     * @param replyMarkup An inline keyboard.
     * @return this request
     */
    public EditMessageReplyMarkup replyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}