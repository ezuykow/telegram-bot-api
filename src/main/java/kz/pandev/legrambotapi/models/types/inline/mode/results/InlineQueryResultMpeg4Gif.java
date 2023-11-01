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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound).
 * By default, this animated MPEG-4 file will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content
 * instead of the animation.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultMpeg4Gif extends InlineQueryResult<InlineQueryResultMpeg4Gif> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "mpeg4_gif";

    /**
     * A valid URL for the MPEG4 file. File size must not exceed 1MB
     */
    @SerializedName("mpeg4_url")
    private String mpeg4Url;

    /**
     * URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
     */
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    /**
     * Optional. Video width
     */
    @SerializedName("mpeg4_width")
    @Nullable
    private Integer mpeg4Width;

    /**
     * Optional. Video height
     */
    @SerializedName("mpeg4_height")
    @Nullable
    private Integer mpeg4Height;

    /**
     * Optional. Video duration in seconds
     */
    @SerializedName("mpeg4_duration")
    @Nullable
    private Integer mpeg4Duration;

    /**
     * Optional. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”.
     * Defaults to “image/jpeg”
     */
    @SerializedName("thumbnail_mime_type")
    private String thumbnailMimeType;

    /**
     * Optional. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
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

    public InlineQueryResultMpeg4Gif(@NotNull String id, @NotNull String mpeg4Url, @NotNull String thumbnailUrl) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.mpeg4Url = mpeg4Url;
        this.thumbnailUrl = thumbnailUrl;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#mpeg4Url}
     * @param mpeg4Url new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif mpeg4Url(String mpeg4Url) {
        this.mpeg4Url = mpeg4Url;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#mpeg4Width}
     * @param mpeg4Width new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif mpeg4Width(Integer mpeg4Width) {
        this.mpeg4Width = mpeg4Width;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#mpeg4Height}
     * @param mpeg4Height new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif mpeg4Height(Integer mpeg4Height) {
        this.mpeg4Height = mpeg4Height;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#mpeg4Duration}
     * @param mpeg4Duration new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif mpeg4Duration(Integer mpeg4Duration) {
        this.mpeg4Duration = mpeg4Duration;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#thumbnailMimeType}
     * @param thumbnailMimeType new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif thumbnailMimeType(String thumbnailMimeType) {
        this.thumbnailMimeType = thumbnailMimeType;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultMpeg4Gif#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultMpeg4Gif}
     */
    public InlineQueryResultMpeg4Gif captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}