package kz.pandev.legrambotapi.models.types.passport.errors;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedPassportElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents an issue with a document scan.
 * The error is considered resolved when the file with the document scan changes.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PassportElementErrorFile extends PassportElementError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String ERROR_SOURCE = "file";

    /**
     * Base64-encoded file hash
     */
    @SerializedName("file_hash")
    private String fileHash;

    public PassportElementErrorFile(@NotNull EncryptedPassportElement.Type type,
                                      @NotNull String fileHash, @NotNull String message) {
        super(ERROR_SOURCE, type, message);
        this.fileHash = fileHash;
    }
}