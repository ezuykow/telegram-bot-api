package kz.pandev.legrambotapi.models.types.passport.errors;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedPassportElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents an issue in an unspecified place. The error is considered resolved when new data is added.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PassportElementErrorUnspecified extends PassportElementError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String ERROR_SOURCE = "unspecified";

    /**
     * Base64-encoded element hash
     */
    @SerializedName("element_hash")
    private String elementHash;

    public PassportElementErrorUnspecified(EncryptedPassportElement.Type type, String message, String elementHash) {
        super(ERROR_SOURCE, type, message);
        this.elementHash = elementHash;
    }
}