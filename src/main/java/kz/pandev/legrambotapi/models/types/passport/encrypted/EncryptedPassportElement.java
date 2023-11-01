package kz.pandev.legrambotapi.models.types.passport.encrypted;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.passport.PassportFile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Describes documents or other Telegram Passport elements shared with the bot by the user.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EncryptedPassportElement implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Type of element {@link EncryptedPassportElement}
     */
    public enum Type {
        @SerializedName("personal_details")
        PERSONAL_DETAILS,
        @SerializedName("passport")
        PASSPORT,
        @SerializedName("driver_license")
        DRIVER_LICENSE,
        @SerializedName("identity_card")
        IDENTITY_CARD,
        @SerializedName("internal_passport")
        INTERNAL_PASSPORT,
        @SerializedName("address")
        ADDRESS,
        @SerializedName("utility_bill")
        UTILITY_BILL,
        @SerializedName("bank_statement")
        BANK_STATEMENT,
        @SerializedName("rental_agreement")
        RENTAL_AGREEMENT,
        @SerializedName("passport_registration")
        PASSPORT_REGISTRATION,
        @SerializedName("temporary_registration")
        TEMPORARY_REGISTRATION,
        @SerializedName("phone_number")
        PHONE_NUMBER,
        @SerializedName("email")
        EMAIL
    }

    /**
     * Element type
     * @see Type
     */
    @SerializedName("type")
    private Type type;

    /**
     * Optional. Base64-encoded encrypted Telegram Passport element data provided by the user,
     * available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”
     * and “address” types. Can be decrypted and verified using the accompanying
     * {@link EncryptedCredentials}
     */
    @SerializedName("data")
    @Nullable
    private String data;

    /**
     * Optional. User's verified phone number, available only for “phone_number” type
     */
    @SerializedName("phone_number")
    @Nullable
    private String phoneNumber;

    /**
     * Optional. User's verified email address, available only for “email” type
     */
    @SerializedName("email")
    @Nullable
    private String email;

    /**
     * Optional. Array of encrypted files with documents provided by the user, available for “utility_bill”,
     * “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types.
     * Files can be decrypted and verified using the accompanying {@link EncryptedCredentials}.
     */
    @SerializedName("files")
    @Nullable
    private List<PassportFile> files;

    /**
     * Optional. Encrypted file with the front side of the document, provided by the user. Available
     * for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted
     * and verified using the accompanying {@link EncryptedCredentials}.
     */
    @SerializedName("front_side")
    @Nullable
    private PassportFile frontSide;

    /**
     * Optional. Encrypted file with the reverse side of the document, provided by the user.
     * Available for “driver_license” and “identity_card”. The file can be decrypted and verified
     * using the accompanying {@link EncryptedCredentials}.
     */
    @SerializedName("reverse_side")
    @Nullable
    private PassportFile reverseSide;

    /**
     * Optional. Encrypted file with the selfie of the user holding a document, provided by the user;
     * available for “passport”, “driver_license”, “identity_card” and “internal_passport”.
     * The file can be decrypted and verified using the accompanying {@link EncryptedCredentials}.
     */
    @SerializedName("selfie")
    @Nullable
    private PassportFile selfie;

    /**
     * Optional. Array of encrypted files with translated versions of documents provided by the user.
     * Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”,
     * “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration”
     * types. Files can be decrypted and verified using the accompanying{@link EncryptedCredentials}.
     */
    @SerializedName("translation")
    @Nullable
    private List<PassportFile> translation;

    /**
     * Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
    @SerializedName("hash")
    @Nullable
    private String hash;
}