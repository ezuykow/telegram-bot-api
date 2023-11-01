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
 * Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated
 * GIF file will be sent by the user with an optional caption. Alternatively, you can use input_message_content
 * to send a message with specified content instead of the animation.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedGif extends InlineQueryResult<InlineQueryResultCachedGif> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "gif";

    /**
     * A valid file identifier for the GIF file
     */
    @SerializedName("gif_file_id")
    private String gifFileId;

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

    public InlineQueryResultCachedGif(@NotNull String id, @NotNull String fileId) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.gifFileId = fileId;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultCachedGif#gifFileId}
     * @param gifFileId new parameter value
     * @return this {@link InlineQueryResultCachedGif}
     */
    public InlineQueryResultCachedGif gifFileId(String gifFileId) {
        this.gifFileId = gifFileId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedGif#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultCachedGif}
     */
    public InlineQueryResultCachedGif caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedGif#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultCachedGif}
     */
    public InlineQueryResultCachedGif parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedGif#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultCachedGif}
     */
    public InlineQueryResultCachedGif captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}