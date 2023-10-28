package kz.pandev.legrambotapi.models.types.message;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class MessageEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Type of the entity. Currently, can be “mention” (@username), “hashtag” (#hashtag), “cashtag” ($USD),
     * “bot_command” (/start@jobs_bot), “url” (<a href="https://telegram.org">https://telegram.org</a>), “email”
     * (do-not-reply@telegram.org), “phone_number” (+1-212-555-0123), “bold” (bold text), “italic” (italic text),
     * “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message), “code”
     * (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention”
     * (for users without usernames), “custom_emoji” (for inline custom emoji stickers)
     */
    @SerializedName("type")
    private String type;

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
}