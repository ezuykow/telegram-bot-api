package kz.pandev.legrambotapi.models.types.stickers;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.File;
import kz.pandev.legrambotapi.models.types.common.PhotoSize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a sticker.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Sticker implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”.
     * The type of the sticker is independent from its format, which is determined by
     * the fields isAnimated and isVideo.
     */
    public enum Type {
        @SerializedName("regular")
        REGULAR,
        @SerializedName("mask")
        MASK,
        @SerializedName("custom_emoji")
        CUSTOM_EMOJI
    }

    /**
     * Unique identifier for this file, which is supposed to be the same over time
     * and for different bots. Can't be used to download or reuse the file.
     */
    @SerializedName("file_unique_id")
    @EqualsAndHashCode.Include
    private String fileUniqueId;

    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    @SerializedName("file_id")
    private String fileId;

    /**
     * Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”.
     * The type of the sticker is independent from its format, which is determined by
     * the fields isAnimated and isVideo.
     */
    @SerializedName("type")
    private Type type;

    /**
     * Sticker width
     */
    @SerializedName("width")
    private Integer width;

    /**
     * Sticker height
     */
    @SerializedName("height")
    private Integer height;

    /**
     *  True, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a>
     */
    @SerializedName("is_animated")
    private Boolean isAnimated;

    /**
     * True, if the sticker is a
     * <a href="https://telegram.org/blog/video-stickers-better-reactions/">video sticker</a>
     */
    @SerializedName("is_video")
    private Integer isVideo;

    /**
     * Optional. Sticker thumbnail in the .WEBP or .JPG format
     */
    @SerializedName("thumbnail")
    @Nullable
    private PhotoSize thumbnail;

    /**
     * Optional. Emoji associated with the sticker
     */
    @SerializedName("emoji")
    @Nullable
    private String emoji;

    /**
     * Optional. Name of the sticker set to which the sticker belongs
     */
    @SerializedName("set_name")
    @Nullable
    private String setName;

    /**
     * Optional. For premium regular stickers, premium animation for the sticker
     */
    @SerializedName("premium_animation")
    @Nullable
    private File premiumAnimation;

    /**
     * Optional. For mask stickers, the position where the mask should be placed
     */
    @SerializedName("mask_position")
    @Nullable
    private MaskPosition maskPosition;

    /**
     * Optional. For custom emoji stickers, unique identifier of the custom emoji
     */
    @SerializedName("custom_emoji_id")
    @Nullable
    private String customEmojiId;

    /**
     * Optional. True, if the sticker must be repainted to a text color in messages, the color of the
     * Telegram Premium badge in emoji status, white color on chat photos, or another appropriate
     * color in other places
     */
    @SerializedName("needs_repainting")
    @Nullable
    private Boolean needsRepainting;

    /**
     * Optional. File size in bytes
     */
    @SerializedName("file_size")
    @Nullable
    private Integer fileSize;
}