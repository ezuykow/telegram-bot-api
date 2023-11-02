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
 * Represents an issue in one of the data fields that was provided by the user.
 * The error is considered resolved when the field's value changes.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PassportElementErrorDataField extends PassportElementError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String ERROR_SOURCE = "data";

    /**
     * Name of the data field which has the error
     */
    @SerializedName("field_name")
    private String fieldName;

    /**
     * Base64-encoded data hash
     */
    @SerializedName("data_hash")
    private String dataHash;

    public PassportElementErrorDataField(@NotNull EncryptedPassportElement.Type type, @NotNull String fieldName,
                                         @NotNull String dataHash, @NotNull String message) {
        super(ERROR_SOURCE, type, message);
        this.fieldName = fieldName;
        this.dataHash = dataHash;
    }
}