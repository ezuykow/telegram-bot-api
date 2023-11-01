package kz.pandev.legrambotapi.models.types.passport.errors;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedPassportElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents an error in the Telegram Passport element which was submitted
 * that should be resolved by the user
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public abstract class PassportElementError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Error source
     */
    @SerializedName("source")
    private final String source;

    /**
     * The section of the user's Telegram Passport which has the error
     */
    @SerializedName("type")
    private final EncryptedPassportElement.Type type;

    /**
     * Error message
     */
    @SerializedName("message")
    private final String message;

    protected PassportElementError(String source, EncryptedPassportElement.Type type, String message) {
        this.source = source;
        this.type = type;
        this.message = message;
    }
}