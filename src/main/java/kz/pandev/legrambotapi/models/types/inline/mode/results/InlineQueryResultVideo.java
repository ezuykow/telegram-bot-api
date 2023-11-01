package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.inline.mode.input.message.content.InputMessageContent;
import kz.pandev.legrambotapi.models.types.inline.mode.input.message.content.InputTextMessageContent;
import kz.pandev.legrambotapi.utils.ParseMode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Represents a link to a page containing an embedded video player or a video file.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the video.
 * @apiNote If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube),
 * you must replace its content using input_message_content.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultVideo extends InlineQueryResult<InlineQueryResultVideo> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "video";

    /**
     * {@link InlineQueryResultVideo} content mime type
     */
    @Getter
    @RequiredArgsConstructor
    public enum MimeType {
        TEXT_HTML("text/html"), VIDEO_MP4("video/mp4");

        private final String textVal;
    }

    /**
     * A valid URL for the embedded video player or video file
     */
    @SerializedName("video_url")
    private String videoUrl;

    /**
     * MIME type of the content of the video URL, “text/html” or “video/mp4”
     * @see MimeType
     */
    @SerializedName("mime_type")
    private String mimeType;

    /**
     * URL of the thumbnail (JPEG only) for the video
     */
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    /**
     * Optional. Caption of the video to be sent, 0-1024 characters after entities parsing
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

    /**
     * Optional. Video width
     */
    @SerializedName("video_width")
    @Nullable
    private Integer videoWidth;

    /**
     * Optional. Video height
     */
    @SerializedName("video_height")
    @Nullable
    private Integer videoHeight;

    /**
     * Optional. Video duration in seconds
     */
    @SerializedName("video_duration")
    @Nullable
    private Integer videoDuration;

    /**
     * Optional. Short description of the result
     */
    @SerializedName("description")
    @Nullable
    private String description;

    public InlineQueryResultVideo(@NotNull String id, @NotNull String videoUrl, @NotNull MimeType mimeType,
                                  @NotNull String messageText, @NotNull String thumbnailUrl, @NotNull String title) {
        this(id, videoUrl, mimeType, new InputTextMessageContent(messageText), thumbnailUrl, title);
    }

    public InlineQueryResultVideo(@NotNull String id, @NotNull String videoUrl, @NotNull MimeType mimeType,
                                  @NotNull InputMessageContent inputMessageContent, @NotNull String thumbnailUrl,
                                  @NotNull String title) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.videoUrl = videoUrl;
        this.mimeType = mimeType.getTextVal();
        this.thumbnailUrl = thumbnailUrl;
        title(title);
        inputMessageContent(inputMessageContent);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultVideo#videoUrl}
     * @param videoUrl new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo videoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#mimeType}
     * @param mimeType new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo mimeType(MimeType mimeType) {
        this.mimeType = mimeType.getTextVal();
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#videoWidth}
     * @param videoWidth new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo videoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#videoHeight}
     * @param videoHeight new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo videoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#videoDuration}
     * @param videoDuration new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo videoDuration(Integer videoDuration) {
        this.videoDuration = videoDuration;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVideo#description}
     * @param description new parameter value
     * @return this {@link InlineQueryResultVideo}
     */
    public InlineQueryResultVideo description(String description) {
        this.description = description;
        return this;
    }

    //endregion
}