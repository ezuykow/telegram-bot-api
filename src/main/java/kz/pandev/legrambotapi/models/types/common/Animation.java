package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound)
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Animation implements Serializable {

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
     * Video width as defined by sender
     */
    @SerializedName("width")
    private Integer width;

    /**
     * Video height as defined by sender
     */
    @SerializedName("height")
    private Integer height;

    /**
     * Duration of the video in seconds as defined by sender
     */
    @SerializedName("duration")
    private Integer duration;

    /**
     * Optional. Animation thumbnail as defined by sender
     */
    @SerializedName("thumbnail")
    @Nullable
    private PhotoSize thumbnail;

    /**
     * Optional. Original animation filename as defined by sender
     */
    @SerializedName("file_name")
    @Nullable
    private String fileName;

    /**
     * Optional. MIME type of the file as defined by sender
     */
    @SerializedName("mime_type")
    @Nullable
    private String mimeType;

    /**
     * Optional. File size in bytes
     */
    @SerializedName("file_size")
    @Nullable
    private Long fileSize;
}