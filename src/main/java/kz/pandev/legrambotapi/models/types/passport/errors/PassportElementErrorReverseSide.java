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
 * Represents an issue with the reverse side of a document.
 * The error is considered resolved when the file with reverse side of the document changes.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PassportElementErrorReverseSide extends PassportElementError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String ERROR_SOURCE = "reverse_side";

    /**
     * Base64-encoded hash of the file with the reverse side of the document
     */
    @SerializedName("file_hash")
    private String fileHash;

    public PassportElementErrorReverseSide(@NotNull EncryptedPassportElement.Type type,
                                           @NotNull String fileHash, @NotNull String message) {
        super(ERROR_SOURCE, type, message);
        this.fileHash = fileHash;
    }
}