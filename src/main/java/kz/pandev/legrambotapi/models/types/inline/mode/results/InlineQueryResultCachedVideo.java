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
 * Represents a link to a video file stored on the Telegram servers. By default, this video file
 * will be sent by the user with an optional caption. Alternatively, you can use input_message_content
 * to send a message with the specified content instead of the video.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedVideo extends InlineQueryResult<InlineQueryResultCachedVideo> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "video";

    /**
     * A valid file identifier for the file
     */
    @SerializedName("video_file_id")
    private String videoFileId;

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

    public InlineQueryResultCachedVideo(@NotNull String id, @NotNull String fileId, @NotNull String title) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.videoFileId = fileId;
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultCachedVideo#videoFileId}
     * @param videoFileId new parameter value
     * @return this {@link InlineQueryResultCachedVideo}
     */
    public InlineQueryResultCachedVideo videoFileId(String videoFileId) {
        this.videoFileId = videoFileId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedVideo#description}
     * @param description new parameter value
     * @return this {@link InlineQueryResultCachedVideo}
     */
    public InlineQueryResultCachedVideo description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedVideo#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultCachedVideo}
     */
    public InlineQueryResultCachedVideo caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedVideo#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultCachedVideo}
     */
    public InlineQueryResultCachedVideo parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedVideo#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultCachedVideo}
     */
    public InlineQueryResultCachedVideo captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}