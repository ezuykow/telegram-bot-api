package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.inline.mode.input.message.content.InputMessageContent;
import kz.pandev.legrambotapi.models.types.inline.mode.input.message.content.InputTextMessageContent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a link to an article or web page.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultArticle extends InlineQueryResult<InlineQueryResultArticle> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "article";

    /**
     * Optional. URL of the result
     */
    @SerializedName("url")
    @Nullable
    private String url;

    /**
     * Optional. Pass True if you don't want the URL to be shown in the message
     */
    @SerializedName("hide_url")
    @Nullable
    private Boolean hideUrl;

    /**
     * Optional. Short description of the result
     */
    @SerializedName("description")
    @Nullable
    private String description;

    /**
     * Optional. Url of the thumbnail for the result
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

    public InlineQueryResultArticle(@NotNull String id, @NotNull String title, @NotNull String messageText) {
        this(id, title, new InputTextMessageContent(messageText));
    }

    public InlineQueryResultArticle(@NotNull String id, @NotNull String title,
                                    @NotNull InputMessageContent inputMessageContent) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        title(title);
        inputMessageContent(inputMessageContent);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultArticle#url}
     * @param url new parameter value
     * @return this {@link InlineQueryResultArticle}
     */
    public InlineQueryResultArticle url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultArticle#hideUrl}
     * @param hideUrl new parameter value
     * @return this {@link InlineQueryResultArticle}
     */
    public InlineQueryResultArticle hideUrl(boolean hideUrl) {
        this.hideUrl = hideUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultArticle#description}
     * @param description new parameter value
     * @return this {@link InlineQueryResultArticle}
     */
    public InlineQueryResultArticle description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultArticle#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultArticle}
     */
    public InlineQueryResultArticle thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultArticle#thumbnailWidth}
     * @param thumbnailWidth new parameter value
     * @return this {@link InlineQueryResultArticle}
     */
    public InlineQueryResultArticle thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultArticle#thumbnailHeight}
     * @param thumbnailHeight new parameter value
     * @return this {@link InlineQueryResultArticle}
     */
    public InlineQueryResultArticle thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    //endregion
}