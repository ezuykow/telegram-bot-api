package kz.pandev.legrambotapi.models.types.passport.credentials.utils;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * These credentials can be used to decrypt encrypted files from the front_side, reverse_side, selfie,
 * files and translation fields in EncryptedPassportElement.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FileCredentials implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Checksum of encrypted file
     */
    @SerializedName("file_hash")
    private String fileHash;

    /**
     * Secret of encrypted file
     */
    @SerializedName("secret")
    private String secret;
}