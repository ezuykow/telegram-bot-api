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
 * This object represents a general file (as opposed to photos, voice messages and audio files)
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Document implements Serializable {

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
     * Optional. Document thumbnail as defined by sender
     */
    @SerializedName("thumbnail")
    @Nullable
    private PhotoSize thumbnail;

    /**
     * Optional. Original filename as defined by sender
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