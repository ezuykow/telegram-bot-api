package kz.pandev.legrambotapi.models.types.inline.mode.input.message.content;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InputTextMessageContent implements InputMessageContent, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Text of the message to be sent, 1-4096 characters
     */
    @SerializedName("message_text")
    private String messageText;

    /**
     * Optional. Mode for parsing entities in the message text. See {@link ParseMode} for more details.
     */
    @SerializedName("parse_mode")
    @Nullable
    private ParseMode parseMode;

    /**
     * Optional. List of special entities that appear in message text, which can be specified instead of parseMode
     */
    @SerializedName("entities")
    @Nullable
    private List<MessageEntity> entities;

    /**
     * Optional. Disables link previews for links in the sent message
     */
    @SerializedName("disable_web_page_preview")
    @Nullable
    private Boolean disableWebPagePreview;

    public InputTextMessageContent(@NotNull String messageText) {
        this.messageText = messageText;
    }

    //region API

    /**
     * Set parameter {@link InputTextMessageContent#messageText}
     * @param messageText new parameter value
     * @return this {@link InputTextMessageContent}
     */
    public InputTextMessageContent messageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    /**
     * Set parameter {@link InputTextMessageContent#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InputTextMessageContent}
     */
    public InputTextMessageContent parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InputTextMessageContent#entities}
     * @param entities new parameter value
     * @return this {@link InputTextMessageContent}
     */
    public InputTextMessageContent entities(List<MessageEntity> entities) {
        this.entities = entities;
        return this;
    }

    /**
     * Set parameter {@link InputTextMessageContent#disableWebPagePreview}
     * @param disableWebPagePreview new parameter value
     * @return this {@link InputTextMessageContent}
     */
    public InputTextMessageContent disableWebPagePreview(boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
        return this;
    }

    //endregion
}