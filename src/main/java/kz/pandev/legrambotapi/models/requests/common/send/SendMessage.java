package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendMessage extends AbstractSendRequest<SendMessage> {

    /**
     * Optional. Mode for parsing entities in the message text. See formatting options for more details.
     * @see ParseMode
     */
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in message text, which can be specified instead of parse_mode
     */
    private List<MessageEntity> entities;
    /**
     * Optional. Disables link previews for links in this message
     */
    private Boolean disableWebPagePreview;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param text Text of the message to be sent, 1-4096 characters after entities parsing
     */
    public SendMessage(@NotNull Object chatId, @NotNull String text) {
        super(chatId);
        addParameter("text", text);
    }

    //region API

    /**
     * Set parameter {@link SendMessage#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public SendMessage parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link SendMessage#entities}
     * @param entities new parameter value
     * @return this request
     */
    public SendMessage entities(@NotNull List<MessageEntity> entities) {
        this.entities = entities;
        return addParameter("entities", entities);
    }

    /**
     * Set parameter {@link SendMessage#disableWebPagePreview}
     * @param disableWebPagePreview new parameter value
     * @return this request
     */
    public SendMessage disableWebPagePreview(boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return addParameter("disable_web_page_preview", disableWebPagePreview);
    }

    //endregion
}