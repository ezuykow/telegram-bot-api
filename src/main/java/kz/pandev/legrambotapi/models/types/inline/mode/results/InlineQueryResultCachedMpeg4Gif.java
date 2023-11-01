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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the
 * Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional
 * caption. Alternatively, you can use input_message_content to send a message with the specified content
 * instead of the animation.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedMpeg4Gif extends InlineQueryResult<InlineQueryResultCachedMpeg4Gif> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "mpeg4_gif";

    /**
     * A valid file identifier for the MPEG4 file
     */
    @SerializedName("mpeg4_file_id")
    private String mpeg4FileId;

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

    public InlineQueryResultCachedMpeg4Gif(@NotNull String id, @NotNull String fileId) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.mpeg4FileId = fileId;
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultCachedMpeg4Gif#mpeg4FileId}
     * @param mpeg4FileId new parameter value
     * @return this {@link InlineQueryResultCachedMpeg4Gif}
     */
    public InlineQueryResultCachedMpeg4Gif mpeg4FileId(String mpeg4FileId) {
        this.mpeg4FileId = mpeg4FileId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedMpeg4Gif#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultCachedMpeg4Gif}
     */
    public InlineQueryResultCachedMpeg4Gif caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedMpeg4Gif#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultCachedMpeg4Gif}
     */
    public InlineQueryResultCachedMpeg4Gif parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultCachedMpeg4Gif#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultCachedMpeg4Gif}
     */
    public InlineQueryResultCachedMpeg4Gif captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    //endregion
}