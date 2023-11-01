package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a link to a sticker stored on the Telegram servers. By default, this sticker will
 * be sent by the user. Alternatively, you can use input_message_content to send a message with
 * the specified content instead of the sticker.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultCachedSticker extends InlineQueryResult<InlineQueryResultCachedSticker> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "sticker";

    /**
     * A valid file identifier of the sticker
     */
    @SerializedName("sticker_file_id")
    private String stickerFileId;

    public InlineQueryResultCachedSticker(String id, String fileId) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.stickerFileId = fileId;
    }
}