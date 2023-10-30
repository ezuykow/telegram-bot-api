package kz.pandev.legrambotapi.models.types.stickers;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.PhotoSize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents a sticker set.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StickerSet  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Sticker set name
     */
    @SerializedName("name")
    private String name;

    /**
     * Sticker set title
     */
    @SerializedName("title")
    private String title;

    /**
     * Type of stickers in the set, currently one of “regular”, “mask”, “custom_emoji”
     */
    @SerializedName("sticker_type")
    private Sticker.Type stickerType;

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
     * List of all set stickers
     */
    @SerializedName("stickers")
    private List<Sticker> stickers;

    /**
     * Optional. Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
     */
    @SerializedName("thumbnail")
    private PhotoSize thumbnail;
}