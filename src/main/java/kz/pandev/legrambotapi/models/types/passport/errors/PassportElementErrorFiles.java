package kz.pandev.legrambotapi.models.types.passport.errors;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedPassportElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Represents an issue with a list of scans.
 * The error is considered resolved when the list of files containing the scans changes.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PassportElementErrorFiles extends PassportElementError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String ERROR_SOURCE = "files";

    /**
     * List of base64-encoded file hashes
     */
    @SerializedName("file_hashes")
    private List<String> fileHashes;

    public PassportElementErrorFiles(@NotNull EncryptedPassportElement.Type type,
                                     @NotNull List<String> fileHashes, @NotNull String message) {
        super(ERROR_SOURCE, type, message);
        this.fileHashes = fileHashes;
    }
}