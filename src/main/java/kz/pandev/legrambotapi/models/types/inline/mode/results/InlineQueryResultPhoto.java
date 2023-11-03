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
 * Represents a link to a photo. By default, this photo will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the photo.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultPhoto extends InlineQueryResult<InlineQueryResultPhoto> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "photo";


    /**
     * A valid URL of the photo. Photo must be in JPEG format. Photo size must not exceed 5MB
     */
    @SerializedName("photo_url")
    private String photoUrl;

    /**
     * URL of the thumbnail for the photo
     */
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    /**
     * Optional. Width of the photo
     */
    @SerializedName("photo_width")
    @Nullable
    private Integer photoWidth;

    /**
     * Optional. Height of the photo
     */
    @SerializedName("photo_height")
    @Nullable
    private Integer photoHeight;

    /**
     * Optional. Short description of the result
     */
    @SerializedName("description")
    @Nullable
    private String description;

    /**
     * Optional. Caption of the photo to be sent, 0-1024 characters after entities parsing
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

    public InlineQueryResultPhoto(@NotNull String id, @NotNull String photoUrl, @NotNull String thumbnailUrl) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.photoUrl = photoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultPhoto#photoUrl}
     * @param photoUrl new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto photoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultPhoto#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultPhoto#photoWidth}
     * @param photoWidth new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto photoWidth(Integer photoWidth) {
        this.photoWidth = photoWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultPhoto#photoHeight}
     * @param photoHeight new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto photoHeight(Integer photoHeight) {
        this.photoHeight = photoHeight;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultPhoto#description}
     * @param description new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultPhoto#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultPhoto#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultPhoto#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultPhoto}
     */
    public InlineQueryResultPhoto captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}