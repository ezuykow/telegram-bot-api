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
 * Represents a link to a voice recording in an .OGG container encoded with OPUS.
 * By default, this voice recording will be sent by the user. Alternatively, you can
 * use input_message_content to send a message with the specified content instead of the voice message.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultVoice extends InlineQueryResult<InlineQueryResultVoice> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "voice";

    /**
     * A valid URL for the voice recording
     */
    @SerializedName("voice_url")
    private String voiceUrl;

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
     * Optional. Recording duration in seconds
     */
    @SerializedName("voice_duration")
    @Nullable
    private Integer voiceDuration;

    public InlineQueryResultVoice(@NotNull String id, @NotNull String voiceUrl, @NotNull String title) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.voiceUrl = voiceUrl;
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultVoice#voiceUrl}
     * @param voiceUrl new parameter value
     * @return this {@link InlineQueryResultVoice}
     */
    public InlineQueryResultVoice voiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVoice#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultVoice}
     */
    public InlineQueryResultVoice caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVoice#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultVoice}
     */
    public InlineQueryResultVoice parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVoice#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultVoice}
     */
    public InlineQueryResultVoice captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVoice#voiceDuration}
     * @param voiceDuration new parameter value
     * @return this {@link InlineQueryResultVoice}
     */
    public InlineQueryResultVoice voiceDuration(Integer voiceDuration) {
        this.voiceDuration = voiceDuration;
        return this;
    }

    //endregion
}