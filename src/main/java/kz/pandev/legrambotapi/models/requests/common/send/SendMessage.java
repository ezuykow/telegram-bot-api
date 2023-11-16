package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendMessage extends AbstractSendRequest<SendMessage> {

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
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the message text. See formatting options for more details.
     * @see ParseMode
     * @return this request
     */
    public SendMessage parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter entities
     * @param entities List of special entities that appear in message text, which
     *                can be specified instead of parse_mode
     * @return this request
     */
    public SendMessage entities(@NotNull List<MessageEntity> entities) {
        return addParameter("entities", entities);
    }

    /**
     * Set parameter disable_web_page_preview
     * @param disableWebPagePreview Disables link previews for links in this message
     * @return this request
     */
    public SendMessage disableWebPagePreview(boolean disableWebPagePreview) {
        return addParameter("disable_web_page_preview", disableWebPagePreview);
    }

    //endregion
}