package kz.pandev.legrambotapi.models.types.input.media;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.utils.DefaultFileNames;
import kz.pandev.legrambotapi.utils.MimeTypes;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a video to be sent.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InputMediaVideo extends InputMedia<InputMediaVideo> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Input media type
     */
    private static final String INPUT_MEDIA_TYPE = "video";

    /**
     * Optional. Video width
     */
    @SerializedName("width")
    @Nullable
    private Integer width;

    /**
     * Optional. Video height
     */
    @SerializedName("height")
    @Nullable
    private Integer height;

    /**
     * Optional. Video duration in seconds
     */
    @SerializedName("duration")
    @Nullable
    private Integer duration;

    /**
     * Optional. Pass True if the uploaded video is suitable for streaming
     */
    @SerializedName("supports_streaming")
    @Nullable
    private Boolean supportsStreaming;

    /**
     * Optional. Pass True if the video needs to be covered with a spoiler animation
     */
    @SerializedName("has_spoiler")
    @Nullable
    private Boolean hasSpoiler;

    /**
     * @param media video as byte array, java.io.File
     *             or String (if it is fileId of file on Telegram bot API server)
     */
    public InputMediaVideo(Object media) {
        super(INPUT_MEDIA_TYPE, media);
    }

    //region API

    /**
     * Set parameter {@link InputMediaVideo#width}
     * @param width new parameter value
     * @return this {@link InputMediaVideo}
     */
    public InputMediaVideo width(int width) {
        this.width = width;
        return this;
    }

    /**
     * Set parameter {@link InputMediaVideo#height}
     * @param height new parameter value
     * @return this {@link InputMediaVideo}
     */
    public InputMediaVideo height(int height) {
        this.height = height;
        return this;
    }

    /**
     * Set parameter {@link InputMediaVideo#duration}
     * @param duration new parameter value
     * @return this {@link InputMediaVideo}
     */
    public InputMediaVideo duration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Set parameter {@link InputMediaVideo#supportsStreaming}
     * @param supportsStreaming new parameter value
     * @return this {@link InputMediaVideo}
     */
    public InputMediaVideo supportsStreaming(boolean supportsStreaming) {
        this.supportsStreaming = supportsStreaming;
        return this;
    }

    /**
     * Set parameter {@link InputMediaVideo#hasSpoiler}
     * @param hasSpoiler new parameter value
     * @return this {@link InputMediaVideo}
     */
    public InputMediaVideo hasSpoiler(boolean hasSpoiler) {
        this.hasSpoiler = hasSpoiler;
        return this;
    }

    /**
     * @return default video file name
     */
    @Override
    protected String getDefaultFileName() {
        return DefaultFileNames.VIDEO_FILE_NAME;
    }

    /**
     * @return default video mime type
     */
    @Override
    protected String getDefaultContentType() {
        return MimeTypes.VIDEO_MIME_TYPE;
    }

    //endregion
}