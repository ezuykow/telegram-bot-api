package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Represents a link to a file. By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 * Currently, only .PDF and .ZIP files can be sent using this method.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultDocument extends InlineQueryResult<InlineQueryResultDocument> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "document";

    /**
     * {@link InlineQueryResultDocument} content mime type
     */
    @Getter
    @RequiredArgsConstructor
    public enum MimeType {
        PDF("application/pdf"), ZIP("application/zip");

        private final String textVal;
    }

    /**
     * A valid URL for the file
     */
    @SerializedName("document_url")
    private String documentUrl;

    /**
     * MIME type of the content of the file, either “application/pdf” or “application/zip”
     */
    @SerializedName("mime_type")
    private String mimeType;

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
     * Optional. Short description of the result
     */
    @SerializedName("description")
    private String description;

    /**
     * Optional. URL of the thumbnail (JPEG only) for the file
     */
    @SerializedName("thumbnail_url")
    @Nullable
    private String thumbnailUrl;

    /**
     * Optional. Thumbnail width
     */
    @SerializedName("thumbnail_width")
    @Nullable
    private Integer thumbnailWidth;

    /**
     * Optional. Thumbnail height
     */
    @SerializedName("thumbnail_height")
    @Nullable
    private Integer thumbnailHeight;

    public InlineQueryResultDocument(@NotNull String id, @NotNull String documentUrl, @NotNull String title,
                                     @NotNull MimeType mimeType) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.documentUrl = documentUrl;
        this.mimeType = mimeType.getTextVal();
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultDocument#documentUrl}
     * @param documentUrl new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument documentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#mimeType}
     * @param mimeType new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument mimeType(MimeType mimeType) {
        this.mimeType = mimeType.getTextVal();
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#caption}
     * @param caption new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument caption(String caption) {
        this.caption = caption;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#parseMode}
     * @param parseMode new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument parseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#captionEntities}
     * @param captionEntities new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument captionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#description}
     * @param description new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#thumbnailWidth}
     * @param thumbnailWidth new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultDocument#thumbnailHeight}
     * @param thumbnailHeight new parameter value
     * @return this {@link InlineQueryResultDocument}
     */
    public InlineQueryResultDocument thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    //endregion
}