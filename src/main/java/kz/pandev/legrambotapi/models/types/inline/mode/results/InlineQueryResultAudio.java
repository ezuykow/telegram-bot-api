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
 * Represents a link to an MP3 audio file. By default, this audio file will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the audio.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultAudio extends InlineQueryResult<InlineQueryResultAudio> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "audio";

    /**
     * A valid URL for the audio file
     */
    @SerializedName("audio_url")
    private String audioUrl;

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

    /**
     * Optional. Performer
     */
    @SerializedName("performer")
    private String performer;

    /**
     * Optional. Audio duration in seconds
     */
    @SerializedName("audio_duration")
    private Integer audioDuration;

    public InlineQueryResultAudio(@NotNull String id, @NotNull String audioUrl, @NotNull String title) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.audioUrl = audioUrl;
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultAudio#audioUrl}
     * @param audioUrl new parameter value
     * @return this {@link InlineQueryResultAudio}
     */
    public InlineQueryResultAudio audioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultAudio#performer}
     * @param performer new parameter value
     * @return this {@link InlineQueryResultAudio}
     */
    public InlineQueryResultAudio performer(String performer) {
        this.performer = performer;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultAudio#audioDuration}
     * @param audioDuration new parameter value
     * @return this {@link InlineQueryResultAudio}
     */
    public InlineQueryResultAudio audioDuration(Integer audioDuration) {
        this.audioDuration = audioDuration;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultAudio#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultAudio}
     */
    public InlineQueryResultAudio caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultAudio#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultAudio}
     */
    public InlineQueryResultAudio parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultAudio#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultAudio}
     */
    public InlineQueryResultAudio captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}