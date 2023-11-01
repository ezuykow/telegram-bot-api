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
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the
 * user with optional caption. Alternatively, you can use input_message_content to send a message with
 * the specified content instead of the animation.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultGif extends InlineQueryResult<InlineQueryResultGif> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "gif";

    /**
     * A valid URL for the GIF file. File size must not exceed 1MB
     */
    @SerializedName("gif_url")
    private String gifUrl;

    /**
     * URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
     */
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    /**
     * Optional. Width of the GIF
     */
    @SerializedName("gif_width")
    @Nullable
    private Integer gifWidth;

    /**
     * Optional. Height of the GIF
     */
    @SerializedName("gif_height")
    @Nullable
    private Integer gifHeight;

    /**
     * Optional. Duration of the GIF in seconds
     */
    @SerializedName("gif_duration")
    @Nullable
    private Integer gifDuration;

    /**
     * Optional. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”.
     * Defaults to “image/jpeg”
     */
    @SerializedName("thumbnail_mime_type")
    private String thumbnailMimeType;

    /**
     * Optional. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
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

    public InlineQueryResultGif(@NotNull String id, @NotNull String gifUrl, @NotNull String thumbnailUrl) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.gifUrl = gifUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultGif#gifUrl}
     * @param gifUrl new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif gifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#gifWidth}
     * @param gifWidth new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif gifWidth(Integer gifWidth) {
        this.gifWidth = gifWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#gifHeight}
     * @param gifHeight new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif gifHeight(Integer gifHeight) {
        this.gifHeight = gifHeight;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#gifDuration}
     * @param gifDuration new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif gifDuration(Integer gifDuration) {
        this.gifDuration = gifDuration;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#thumbnailMimeType}
     * @param thumbnailMimeType new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif thumbnailMimeType(String thumbnailMimeType) {
        this.thumbnailMimeType = thumbnailMimeType;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultGif#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultGif}
     */
    public InlineQueryResultGif captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}