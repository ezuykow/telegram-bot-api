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
 * Represents an issue with the translated version of a document.
 * The error is considered resolved when a file with the document translation change.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PassportElementErrorTranslationFiles extends PassportElementError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String ERROR_SOURCE = "translation_files";

    /**
     * List of base64-encoded file hashes
     */
    @SerializedName("file_hashes")
    private List<String> fileHashes;

    public PassportElementErrorTranslationFiles(@NotNull EncryptedPassportElement.Type type,
                                                @NotNull List<String> fileHashes, @NotNull String message) {
        super(ERROR_SOURCE, type, message);
        this.fileHashes = fileHashes;
    }
}