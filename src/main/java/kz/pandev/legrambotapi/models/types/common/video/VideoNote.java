package kz.pandev.legrambotapi.models.types.common.video;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.PhotoSize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0)
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class VideoNote implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
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
     * Video width and height (diameter of the video message) as defined by sender
     */
    @SerializedName("length")
    private Integer length;

    /**
     * Duration of the video in seconds as defined by sender
     */
    @SerializedName("duration")
    private Integer duration;

    /**
     * Optional. Video thumbnail
     */
    @SerializedName("thumbnail")
    @Nullable
    private PhotoSize thumbnail;

    /**
     * Optional. File size in bytes
     */
    @SerializedName("file_size")
    @Nullable
    private Integer fileSize;
}