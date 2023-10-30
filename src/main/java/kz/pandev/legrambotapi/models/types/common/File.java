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
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link, which can be obtained by method
 * {@link kz.pandev.legrambotapi.configure.TelegramBot#getFullFilePath(File)}. It is guaranteed that the link will
 * be valid for at least 1 hour (for default Telegram bot API server). When the link expires, a new one can be
 * requested by executing GetFile request.
 * The file content as byte array can be obtained by method
 * {@link kz.pandev.legrambotapi.configure.TelegramBot#getFileContent(File)}
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class File implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file
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
     * Optional. File size in bytes
     */
    @SerializedName("file_size")
    @Nullable
    private Long fileSize;

    /**
     * Optional. File path on Telegram bot API server
     */
    @SerializedName("file_path")
    @Nullable
    private String filePath;
}