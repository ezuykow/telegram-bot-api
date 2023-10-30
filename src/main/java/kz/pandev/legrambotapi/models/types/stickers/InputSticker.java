package kz.pandev.legrambotapi.models.types.stickers;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.utils.Constant;
import kz.pandev.legrambotapi.utils.UniqueNameGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object describes a sticker to be added to a sticker set
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InputSticker implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Prefix of generated names
     */
    private static final String NAME_GENERATOR_PREFIX = "InputSticker";

    /**
     * The added sticker. Pass a file_id as a String to send a file that already exists on the
     * Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet,
     * upload a new one using multipart/form-data, or pass “attach://&lt;file_attach_name&gt;”
     * to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name.
     * Animated and video stickers can't be uploaded via HTTP URL
     */
    @SerializedName("sticker")
    private String sticker;

    /**
     * List of 1-20 emoji associated with the sticker
     */
    @SerializedName("emoji_list")
    private List<String> emojiList;

    /**
     * Optional. Position where the mask should be placed on faces. For “mask” stickers only.
     */
    @SerializedName("mask_position")
    @Nullable
    private MaskPosition maskPosition;

    /**
     * Optional. List of 0-20 search keywords for the sticker with total length of up
     * to 64 characters. For “regular” and “custom_emoji” stickers only.
     */
    @SerializedName("keywords")
    @Nullable
    private List<String> keywords;

    /**
     * Generated name for attach object
     */
    private transient String attachName;

    /**
     * attached object
     */
    private transient Object attachment;

    /**
     * @param sticker fileId as String of file on Telegram server, <br>
     *               HTTP URL as String of file from Internet <br>
     *                or a new one sticker
     * @param emojiList {@link InputSticker#emojiList}
     */
    public InputSticker(@NotNull Object sticker, @NotNull List<String> emojiList) {
        this.emojiList = emojiList;
        if (sticker instanceof String s) {
            this.sticker = s;
        } else {
            this.attachment = sticker;
            this.attachName = UniqueNameGenerator.next(NAME_GENERATOR_PREFIX);
            this.sticker = Constant.TELEGRAM_ATTACH_TAG + this.attachName;
        }
    }

    /**
     * Set parameter {@link InputSticker#maskPosition}
     * @param maskPosition new parameter value
     * @return this {@link InputSticker}
     */
    public InputSticker maskPosition(MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
        return this;
    }

    /**
     * Set parameter {@link InputSticker#keywords}
     * @param keywords new parameter value
     * @return this {@link InputSticker}
     */
    public InputSticker keywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }
}