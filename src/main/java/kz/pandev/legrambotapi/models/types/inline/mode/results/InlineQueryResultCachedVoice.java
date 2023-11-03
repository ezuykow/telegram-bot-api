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
 * Represents a link to a voice message stored on the Telegram servers. By default, this voice
 * message will be sent by the user. Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the voice message.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedVoice extends InlineQueryResult<InlineQueryResultCachedVoice> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "voice";

    /**
     * A valid file identifier for the voice message
     */
    @SerializedName("voice_file_id")
    private String voiceFileId;

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

    public InlineQueryResultCachedVoice(@NotNull String id, @NotNull String fileId, @NotNull String title) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.voiceFileId = fileId;
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultCachedVoice#voiceFileId}
     * @param voiceFileId new parameter value
     * @return this {@link InlineQueryResultCachedVoice}
     */
    public InlineQueryResultCachedVoice voiceFileId(String voiceFileId) {
        this.voiceFileId = voiceFileId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedVoice#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultCachedVoice}
     */
    public InlineQueryResultCachedVoice caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedVoice#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultCachedVoice}
     */
    public InlineQueryResultCachedVoice parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedVoice#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultCachedVoice}
     */
    public InlineQueryResultCachedVoice captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}