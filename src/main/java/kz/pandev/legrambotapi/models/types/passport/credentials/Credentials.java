package kz.pandev.legrambotapi.models.types.passport.credentials;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.credentials.utils.SecureData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Credentials
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Credentials implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Credentials for encrypted data
     */
    @SerializedName("secure_data")
    private SecureData secureData;

    /**
     * Bot-specified nonce
     */
    @SerializedName("nonce")
    private String nonce;
}