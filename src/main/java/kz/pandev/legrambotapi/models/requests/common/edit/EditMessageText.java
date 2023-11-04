package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Use this method to edit text and game messages. On success, if the edited message
 * is not an inline message, the edited Message is returned, otherwise True is returned.
 * @author ezuykow
 */
@Getter
public class EditMessageText extends Request<EditMessageText, Response> {

    /**
     * Optional. Mode for parsing entities in the message text
     */
    @Nullable
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in message text, which can be specified instead of parse_mode
     */
    @Nullable
    private List<MessageEntity> entities;
    /**
     * Optional. Disables link previews for links in this message
     */
    @Nullable
    private Boolean disableWebPagePreview;
    /**
     * Optional. An inline keyboard.
     */
    @Nullable
    private InlineKeyboardMarkup replyMarkup;

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
     * Set parameter {@link EditMessageText#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public EditMessageText parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link EditMessageText#entities}
     * @param entities new parameter value
     * @return this request
     */
    public EditMessageText entities(@NotNull List<MessageEntity> entities) {
        this.entities = entities;
        return addParameter("entities", entities);
    }

    /**
     * Set parameter {@link EditMessageText#disableWebPagePreview}
     * @param disableWebPagePreview new parameter value
     * @return this request
     */
    public EditMessageText disableWebPagePreview(boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return addParameter("disable_web_page_preview", disableWebPagePreview);
    }

    /**
     * Set parameter {@link EditMessageText#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this request
     */
    public EditMessageText replyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}