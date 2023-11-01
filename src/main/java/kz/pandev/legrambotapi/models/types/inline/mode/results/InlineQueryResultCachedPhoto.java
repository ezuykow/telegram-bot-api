package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.ParseMode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Represents a link to a photo stored on the Telegram servers. By default, this photo will be
 * sent by the user with an optional caption. Alternatively, you can use input_message_content to
 * send a message with the specified content instead of the photo.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedPhoto extends InlineQueryResult<InlineQueryResultCachedPhoto> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "photo";

    /**
     * A valid file identifier of the photo
     */
    @SerializedName("photo_file_id")
    private String photoFileId;

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

    public InlineQueryResultCachedPhoto(@NotNull String id, @NotNull String fileId) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.photoFileId = fileId;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultCachedPhoto#photoFileId}
     * @param photoFileId new parameter value
     * @return this {@link InlineQueryResultCachedPhoto}
     */
    public InlineQueryResultCachedPhoto photoFileId(String photoFileId) {
        this.photoFileId = photoFileId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedPhoto#description}
     * @param description new parameter value
     * @return this {@link InlineQueryResultCachedPhoto}
     */
    public InlineQueryResultCachedPhoto description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedPhoto#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultCachedPhoto}
     */
    public InlineQueryResultCachedPhoto caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedPhoto#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultCachedPhoto}
     */
    public InlineQueryResultCachedPhoto parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedPhoto#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultCachedPhoto}
     */
    public InlineQueryResultCachedPhoto captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}