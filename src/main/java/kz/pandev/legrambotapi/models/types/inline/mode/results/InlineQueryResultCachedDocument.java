package kz.pandev.legrambotapi.models.types.inline.mode.results;

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
 * Represents a link to a file stored on the Telegram servers. By default,
 * this file will be sent by the user with an optional caption. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the file.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedDocument extends InlineQueryResult<InlineQueryResultCachedDocument> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "document";

    /**
     * A valid file identifier for the file
     */
    @SerializedName("document_file_id")
    private String documentFileId;

    /**
     * Optional. Short description of the result
     */
    @SerializedName("description")
    @Nullable
    private String description;

    /**
     * Optional. Caption, 0-1024 characters after entities parsing
     */
    @SerializedName("caption")
    @Nullable
    private String caption;

    /**
     * Optional. Mode for parsing entities in the caption
     * @see ParseMode
     */
    @SerializedName("parse_mode")
    @Nullable
    private ParseMode parseMode;

    /**
     * Optional. List of special entities that appear in the caption, which can be specified instead of parseMode
     */
    @SerializedName("caption_entities")
    @Nullable
    private List<MessageEntity> captionEntities;

    public InlineQueryResultCachedDocument(@NotNull String id, @NotNull String documentFileId, @NotNull String title) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.documentFileId = documentFileId;
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultCachedDocument#documentFileId}
     * @param documentFileId new parameter value
     * @return this {@link InlineQueryResultCachedDocument}
     */
    public InlineQueryResultCachedDocument documentFileId(String documentFileId) {
        this.documentFileId = documentFileId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedDocument#description}
     * @param description new parameter value
     * @return this {@link InlineQueryResultCachedDocument}
     */
    public InlineQueryResultCachedDocument description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedDocument#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultCachedDocument}
     */
    public InlineQueryResultCachedDocument caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedDocument#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultCachedDocument}
     */
    public InlineQueryResultCachedDocument parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedDocument#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultCachedDocument}
     */
    public InlineQueryResultCachedDocument captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}