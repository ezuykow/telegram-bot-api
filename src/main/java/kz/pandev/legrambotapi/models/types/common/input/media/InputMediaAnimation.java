package kz.pandev.legrambotapi.models.types.common.input.media;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.utils.DefaultFileNames;
import kz.pandev.legrambotapi.utils.MimeTypes;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InputMediaAnimation extends InputMedia<InputMediaAnimation> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Input media type
     */
    private static final String INPUT_MEDIA_TYPE = "animation";

    /**
     * Optional. Animation width
     */
    @SerializedName("width")
    @Nullable
    private Integer width;

    /**
     * Optional. Animation height
     */
    @SerializedName("height")
    @Nullable
    private Integer height;

    /**
     * Optional. Animation duration in seconds
     */
    @SerializedName("duration")
    @Nullable
    private Integer duration;

    /**
     * Optional. Pass True if the animation needs to be covered with a spoiler animation
     */
    @SerializedName("has_spoiler")
    @Nullable
    private Boolean hasSpoiler;

    /**
     * @param media animation as byte array, java.io.File
     *             or String (if it is fileId of file on Telegram bot API server)
     */
    public InputMediaAnimation(Object media) {
        super(INPUT_MEDIA_TYPE, media);
    }

    //region API

    /**
     * Set parameter {@link InputMediaAnimation#width}
     * @param width new parameter value
     * @return this {@link InputMediaAnimation}
     */
    public InputMediaAnimation width(int width) {
        this.width = width;
        return this;
    }

    /**
     * Set parameter {@link InputMediaAnimation#height}
     * @param height new parameter value
     * @return this {@link InputMediaAnimation}
     */
    public InputMediaAnimation height(int height) {
        this.height = height;
        return this;
    }

    /**
     * Set parameter {@link InputMediaAnimation#duration}
     * @param duration new parameter value
     * @return this {@link InputMediaAnimation}
     */
    public InputMediaAnimation duration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Set parameter {@link InputMediaAnimation#hasSpoiler}
     * @param hasSpoiler new parameter value
     * @return this {@link InputMediaAnimation}
     */
    public InputMediaAnimation hasSpoiler(boolean hasSpoiler) {
        this.hasSpoiler = hasSpoiler;
        return this;
    }

    /**
     * @return default animation file name
     */
    @Override
    protected String getDefaultFileName() {
        return DefaultFileNames.GIF_FILE_NAME;
    }

    /**
     * @return default animation mime type
     */
    @Override
    protected String getDefaultContentType() {
        return MimeTypes.GIF_MIME_TYPE;
    }

    //endregion
}