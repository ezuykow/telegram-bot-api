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
 * Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio
 * file will be sent by the user. Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the audio.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedAudio extends InlineQueryResult<InlineQueryResultCachedAudio> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "audio";

    /**
     * A valid file identifier for the voice message
     */
    @SerializedName("audio_file_id")
    private String audioFileId;

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

    public InlineQueryResultCachedAudio(@NotNull String id, @NotNull String fileId) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.audioFileId = fileId;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultCachedAudio#audioFileId}
     * @param audioFileId new parameter value
     * @return this {@link InlineQueryResultCachedAudio}
     */
    public InlineQueryResultCachedAudio audioFileId(String audioFileId) {
        this.audioFileId = audioFileId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedAudio#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultCachedAudio}
     */
    public InlineQueryResultCachedAudio caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedAudio#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultCachedAudio}
     */
    public InlineQueryResultCachedAudio parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedAudio#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultCachedAudio}
     */
    public InlineQueryResultCachedAudio captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}