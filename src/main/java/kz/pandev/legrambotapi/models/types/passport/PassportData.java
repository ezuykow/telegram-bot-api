package kz.pandev.legrambotapi.models.types.passport;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedCredentials;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedPassportElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Describes Telegram Passport data shared with the bot by the user
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PassportData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Array with information about documents and other Telegram Passport elements that was shared with the bot
     */
    @SerializedName("data")
    private List<EncryptedPassportElement> data;

    /**
     * Encrypted credentials required to decrypt the data
     */
    @SerializedName("credentials")
    private EncryptedCredentials credentials;
}