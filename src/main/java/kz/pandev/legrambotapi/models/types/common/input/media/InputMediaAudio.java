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
 * Represents an audio file to be treated as music to be sent.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InputMediaAudio extends InputMedia<InputMediaAudio> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Input media type
     */
    private static final String INPUT_MEDIA_TYPE = "audio";

    /**
     * Optional. Duration of the audio in seconds
     */
    @SerializedName("duration")
    @Nullable
    private Integer duration;

    /**
     * Optional. Performer of the audio
     */
    @SerializedName("performer")
    @Nullable
    private String performer;

    /**
     * Optional. Title of the audio
     */
    @SerializedName("title")
    @Nullable
    private String title;

    /**
     * @param media audio as byte array, java.io.File
     *             or String (if it is fileId of file on Telegram bot API server)
     */
    public InputMediaAudio(Object media) {
        super(INPUT_MEDIA_TYPE, media);
    }

    //region API

    /**
     * Set parameter {@link InputMediaAudio#duration}
     * @param duration new parameter value
     * @return this {@link InputMediaAudio}
     */
    public InputMediaAudio duration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Set parameter {@link InputMediaAudio#performer}
     * @param performer new parameter value
     * @return this {@link InputMediaAudio}
     */
    public InputMediaAudio performer(String performer) {
        this.performer = performer;
        return this;
    }

    /**
     * Set parameter {@link InputMediaAudio#title}
     * @param title new parameter value
     * @return this {@link InputMediaAudio}
     */
    public InputMediaAudio title(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return default audio file name
     */
    @Override
    protected String getDefaultFileName() {
        return DefaultFileNames.AUDIO_FILE_NAME;
    }

    /**
     * @return default audio mime type
     */
    @Override
    protected String getDefaultContentType() {
        return MimeTypes.AUDIO_MIME_TYPE;
    }

    //endregion
}