package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.inline.mode.input.message.content.InputMessageContent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

/**
 * This object represents one result of an inline query.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public abstract class InlineQueryResult<T extends InlineQueryResult<T>> {

    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    @SerializedName("id")
    @EqualsAndHashCode.Include
    private String id;

    /**
     * Type of the result
     */
    @SerializedName("type")
    private String type;

    /**
     * Optional. Title of the result
     */
    @SerializedName("title")
    @Nullable
    private String title;

    /**
     * Optional. Content of the message to be sent
     */
    @SerializedName("input_message_content")
    @Nullable
    private InputMessageContent inputMessageContent;

    /**
     * Optional. Inline keyboard attached to the message
     */
    @SerializedName("reply_markup")
    @Nullable
    private InlineKeyboardMarkup replyMarkup;

    protected InlineQueryResult(String type, String id) {
        this.type = type;
        this.id = id;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResult#title}
     * @param title new parameter value
     * @return this
     */
    @SuppressWarnings("unchecked") //Cast warning - no error
    public T title(String title) {
        this.title = title;
        return (T) this;
    }

    /**
     * Set parameter {@link InlineQueryResult#inputMessageContent}
     * @param inputMessageContent new parameter value
     * @return this
     */
    @SuppressWarnings("unchecked") //Cast warning - no error
    public T inputMessageContent(InputMessageContent inputMessageContent) {
        this.inputMessageContent = inputMessageContent;
        return (T) this;
    }

    /**
     * Set parameter {@link InlineQueryResult#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this
     */
    @SuppressWarnings("unchecked") //Cast warning - no error
    public T replyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return (T) this;
    }

    //endregion
}