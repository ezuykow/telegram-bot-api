package kz.pandev.legrambotapi.models.types.passport.credentials.utils;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * These credentials can be used to decrypt encrypted data from the data field in EncryptedPassportElement.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DataCredentials implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Checksum of encrypted data
     */
    @SerializedName("data_hash")
    private String dataHash;

    /**
     * Secret of encrypted data
     */
    @SerializedName("secret")
    private String secret;
}