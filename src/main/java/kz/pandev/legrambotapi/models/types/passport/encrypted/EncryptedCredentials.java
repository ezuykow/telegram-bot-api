package kz.pandev.legrambotapi.models.types.passport.encrypted;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.credentials.Credentials;
import kz.pandev.legrambotapi.models.types.passport.credentials.utils.decrypt.Decryptor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Describes data required for decrypting and authenticating EncryptedPassportElement.
 * See the Telegram Passport Documentation for a complete description of the data decryption and
 * authentication processes.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EncryptedCredentials implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Base64-encoded encrypted JSON-serialized data with unique user's payload,
     * data hashes and secrets required for EncryptedPassportElement decryption and authentication
     */
    @SerializedName("data")
    private String data;

    /**
     * Base64-encoded data hash for data authentication
     */
    @SerializedName("hash")
    private String hash;

    /**
     * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    @SerializedName("secret")
    private String secret;

    //region API

    /**
     * Decrypt credentials
     */
    public Credentials decrypt(String privateKey) throws Exception {
        return Decryptor.decryptCredentials(privateKey, data, hash, secret);
    }

    //endregion
}