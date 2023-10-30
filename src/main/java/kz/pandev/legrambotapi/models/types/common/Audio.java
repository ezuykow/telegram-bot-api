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
 * This object represents an audio file to be treated as music by the Telegram clients
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Audio implements Serializable {

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

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("performer")
    @Nullable
    private String performer;

    @SerializedName("title")
    @Nullable
    private String title;

    @SerializedName("file_name")
    @Nullable
    private String fileName;

    @SerializedName("mime_type")
    @Nullable
    private String mimeType;

    @SerializedName("file_size")
    @Nullable
    private Long fileSize;

    @SerializedName("thumbnail")
    @Nullable
    private PhotoSize thumbnail;
}