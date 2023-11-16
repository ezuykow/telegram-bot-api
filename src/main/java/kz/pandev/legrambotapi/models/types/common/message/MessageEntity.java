package kz.pandev.legrambotapi.models.types.common.message;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class MessageEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Type of the message entity
     */
    public enum Type {
        @SerializedName("mention") MENTION,
        @SerializedName("hashtag") HASHTAG,
        @SerializedName("cashtag") CASHTAG,
        @SerializedName("bot_command") BOT_COMMAND,
        @SerializedName("url") URL,
        @SerializedName("email") EMAIL,
        @SerializedName("phone_number") PHONE_NUMBER,
        @SerializedName("bold") BOLD,
        @SerializedName("italic") ITALIC,
        @SerializedName("code") CODE,
        @SerializedName("pre") PRE,
        @SerializedName("text_link") TEXT_LINK,
        @SerializedName("text_mention") TEXT_MENTION,
        @SerializedName("underline") UNDERLINE,
        @SerializedName("strikethrough") STRIKETHROUGH,
        @SerializedName("spoiler") SPOILER,
        @SerializedName("custom_emoji") CUSTOM_EMOJI
    }

    /**
     * Type of the entity. Currently, can be “mention” (@username), “hashtag” (#hashtag), “cashtag” ($USD),
     * “bot_command” (/start@jobs_bot), “url” (<a href="https://telegram.org">https://telegram.org</a>), “email”
     * (do-not-reply@telegram.org), “phone_number” (+1-212-555-0123), “bold” (bold text), “italic” (italic text),
     * “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message), “code”
     * (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention”
     * (for users without usernames), “custom_emoji” (for inline custom emoji stickers)
     */
    @SerializedName("type")
    private Type type;

    /**
     * Offset in UTF-16 code units to the start of the entity
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * Length of the entity in UTF-16 code units
     */
    @SerializedName("length")
    private Integer length;

    /**
     * Optional. For “text_link” only, URL that will be opened after user taps on the text
     */
    @SerializedName("url")
    @Nullable
    private String url;

    /**
     * Optional. For “text_mention” only, the mentioned user
     */
    @SerializedName("user")
    @Nullable
    private User user;

    /**
     * Optional. For “pre” only, the programming language of the entity text
     */
    @SerializedName("language")
    @Nullable
    private String language;

    /**
     * Optional. For “custom_emoji” only, unique identifier of the custom emoji. Use getCustomEmojiStickers to get
     * full information about the sticker
     */
    @SerializedName("custom_emoji_id")
    @Nullable
    private String customEmojiId;

    /**
     * @param type Type of the entity as {@link Type}
     * @param offset Offset in UTF-16 code units to the start of the entity
     * @param length Length of the entity in UTF-16 code units
     */
    public MessageEntity(@NotNull Type type, int offset, int length) {
        this.type = type;
        this.offset = offset;
        this.length = length;
    }

    //region API

    /**
     * Set parameter {@link MessageEntity#type}
     * @param type new parameter value
     * @return this request
     */
    public MessageEntity type(@NotNull Type type) {
        this.type = type;
        return this;
    }

    /**
     * Set parameter {@link MessageEntity#offset}
     * @param offset new parameter value
     * @return this request
     */
    public MessageEntity offset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Set parameter {@link MessageEntity#length}
     * @param length new parameter value
     * @return this request
     */
    public MessageEntity length(int length) {
        this.length = length;
        return this;
    }

    /**
     * Set parameter {@link MessageEntity#url}
     * @param url new parameter value
     * @return this request
     */
    public MessageEntity url(@NotNull String url) {
        this.url = url;
        return this;
    }

    /**
     * Set parameter {@link MessageEntity#user}
     * @param user new parameter value
     * @return this request
     */
    public MessageEntity user(@NotNull User user) {
        this.user = user;
        return this;
    }

    /**
     * Set parameter {@link MessageEntity#language}
     * @param language new parameter value
     * @return this request
     */
    public MessageEntity language(@NotNull String language) {
        this.language = language;
        return this;
    }

    /**
     * Set parameter {@link MessageEntity#customEmojiId}
     * @param customEmojiId new parameter value
     * @return this request
     */
    public MessageEntity customEmojiId(@NotNull String customEmojiId) {
        this.customEmojiId = customEmojiId;
        return this;
    }

    //endregion
}