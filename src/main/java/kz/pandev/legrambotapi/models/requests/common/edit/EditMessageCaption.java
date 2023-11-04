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
 * Use this method to edit captions of messages. On success, if the edited message
 * is not an inline message, the edited Message is returned, otherwise True is returned.
 * @author ezuykow
 */
@Getter
public class EditMessageCaption extends Request<EditMessageCaption, Response> {

    /**
     * Optional. New caption of the message, 0-1024 characters after entities parsing
     */
    @Nullable
    private String caption;
    /**
     * Optional. Mode for parsing entities in the message caption
     */
    @Nullable
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in message text, which can be specified instead of parse_mode
     */
    @Nullable
    private List<MessageEntity> captionEntities;
    /**
     * Optional. An inline keyboard.
     */
    @Nullable
    private InlineKeyboardMarkup replyMarkup;

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
     * Set parameter {@link EditMessageCaption#caption}
     * @param caption new parameter value
     * @return this request
     */
    public EditMessageCaption parseMode(@NotNull String caption) {
        this.caption = caption;
        return addParameter("caption", caption);
    }

    /**
     * Set parameter {@link EditMessageCaption#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public EditMessageCaption parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link EditMessageCaption#captionEntities}
     * @param entities new parameter value
     * @return this request
     */
    public EditMessageCaption entities(@NotNull List<MessageEntity> entities) {
        this.captionEntities = entities;
        return addParameter("entities", entities);
    }

    /**
     * Set parameter {@link EditMessageCaption#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this request
     */
    public EditMessageCaption replyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}